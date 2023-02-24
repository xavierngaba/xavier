package com.udemy.xavier.producer.impl;

import com.udemy.xavier.json.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.udemy.xavier.producer.IProducer;

@Component
public class Producer implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${udemy.rabbitmq.exchange}")
    private String exchange;
    @Value("${udemy.rabbitmq.rootingkey}")
    private String rootingKey;
    @Override
    public void produceMessage(Student student) {
        amqpTemplate.convertAndSend(exchange, rootingKey, student);
        System.out.println("Sending message = " + student.toString());
    }
}
