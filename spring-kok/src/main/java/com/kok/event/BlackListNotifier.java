package com.kok.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * implements ApplicationListener<EmailEvent>
 */
@Component
public class BlackListNotifier {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void onApplicationEvent(EmailEvent event) {
		System.out.println(1);
        // notify appropriate parties via notificationAddress...
    }
}