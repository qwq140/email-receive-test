package com.example.integrationtest.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

//@Configuration
public class TestConfig {

    private static Log logger = LogFactory.getLog(TestConfig.class);

//    @Bean
    public void imapTestApp(){
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
                "/META-INF/spring/integration/gmail-imap-idle-config.xml");
        DirectChannel inputChannel = ac.getBean("receiveChannel", DirectChannel.class);
        inputChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                logger.info("Message: " + message);
            }
        });
    }

}
