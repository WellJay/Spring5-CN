package com.kok.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wenjie
 * @description
 * @date 2019/7/13 14:15
 */

public class BeanFactory {

    public static final String PROPERTY_STR = "property";
    private Map<String, Object> beanMap = new ConcurrentHashMap<>();

    //延迟加载bean
    private List<Element> lazyElementList = new ArrayList<>();

    public BeanFactory(String xml) throws Exception {
        parseXml(xml);
    }

    public void parseXml(String xml) throws Exception {
        String path = this.getClass().getResource("/").getPath() + xml;

        SAXReader reader = new SAXReader();
        Document document = reader.read(path);

        Element root = document.getRootElement();

        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
            Element element = it.next();

            //有子类延迟加载
            if (element.elementIterator().hasNext()) {
                lazyElementList.add(element);
            }

            processElement(element);
        }

        //处理延迟bean
        for (Element element : lazyElementList) {
            processElement(element);
        }
    }

    private void processElement(Element element) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //得到id和object
        String id = element.attribute("id").getValue();
        String aClassPath = element.attribute("class").getValue();

        //反射得到对象
        Class<?> aClass = Class.forName(aClassPath);

        Object obj = aClass.newInstance();

        for (Iterator<Element> innerIt = element.elementIterator(); innerIt.hasNext();) {
            if (innerIt.hasNext()) {
                Element innerElement = innerIt.next();
                String qualifiedName = innerElement.getQualifiedName();
                if(PROPERTY_STR.equals(qualifiedName)){

                   //带有属性参数
                    String name = innerElement.attribute("name").getValue();
                    String ref = innerElement.attribute("ref").getValue();

                    Object injectObject = beanMap.get(ref);

                    Field declaredField = aClass.getDeclaredField(name);
                    declaredField.setAccessible(Boolean.TRUE);
                    declaredField.set(obj, injectObject);
                }
            }
        }
        beanMap.put(id, obj);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }

}
