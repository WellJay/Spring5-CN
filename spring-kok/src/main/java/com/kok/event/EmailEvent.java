package com.kok.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

/**
 * @author wenjie
 * @description
 * @time 2019/7/11 0011 13:05
 */
public class EmailEvent extends ApplicationEvent {

	private String address;

	private String content;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public EmailEvent(Object source, String address, String content) {
		super(source);
		this.address = address;
		this.content = content;
	}
}
