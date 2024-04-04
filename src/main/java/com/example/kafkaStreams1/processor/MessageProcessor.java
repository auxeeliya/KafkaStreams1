package com.example.kafkaStreams1.processor;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageProcessor {

    @Autowired
    private StreamsBuilder builder;

    @PostConstruct
    public void streamTopology(){
        KStream<String, String> stream = builder.stream("spring.boot.kafka.stream.input", Consumed.with(Serdes.String(), Serdes.String()));
        stream.filter((key,value)->value.startsWith("Message_"))
                .mapValues((k,v)->v.toUpperCase())
                .peek((k,v)->System.out.println("Key :"+k+"value:"+v))
                .to("spring.boot.kafka.streams.output",Produced.with(Serdes.String(),Serdes.String()));
    }
}
