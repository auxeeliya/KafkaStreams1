package com.example.kafkaStreams1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class KafkaStreams1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreams1Application.class, args);
	}

}
