package com.example.kafkaStreams1.kafkaconfig;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public StreamsConfig streamsConfig(KafkaProperties props){
        return new StreamsConfig(props.buildStreamsProperties(null));
    }
}
