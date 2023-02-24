package com.udemy.xavier.producer;

import com.udemy.xavier.json.Student;

public interface IProducer {
    void produceMessage(Student student);
}
