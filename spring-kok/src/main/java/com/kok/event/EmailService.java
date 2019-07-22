package com.kok.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenjie
 * @description  implements ApplicationEventPublisherAware
 * @time 2019/7/11 0011 13:06
 */
@Service
public class EmailService {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	private List<String> blackList = new ArrayList<String>(){{
		add("1569925@qq.com");
	}};

	public void sendEmail(String address, String content) {
		if (blackList.contains(address)) {
			applicationEventPublisher.publishEvent(new EmailEvent(this, address, content));
			return;
		}
		// send email...
	}
}
