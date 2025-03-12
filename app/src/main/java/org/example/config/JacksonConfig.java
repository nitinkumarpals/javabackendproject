package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.entities.Train;
import org.example.utils.TrainDeserializer;

public class JacksonConfig {
    
    private static ObjectMapper objectMapper;
    
    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = createObjectMapper();
        }
        return objectMapper;
    }
    
    private static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        
        // Register custom deserializers
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Train.class, new TrainDeserializer());
        mapper.registerModule(module);
        
        return mapper;
    }
} 