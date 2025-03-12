package org.example.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.example.entities.Train;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrainDeserializer extends StdDeserializer<Train> {
    
    public TrainDeserializer() {
        this(null);
    }
    
    public TrainDeserializer(Class<?> vc) {
        super(vc);
    }
    
    @Override
    public Train deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        
        // Extract other Train properties from the node
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        // ... other properties
        
        // Handle the stations property - extract strings from the object
        List<String> stations = new ArrayList<>();
        JsonNode stationsNode = node.get("stations");
        
        if (stationsNode.isObject()) {
            // If stations is an object, extract values as strings
            Iterator<Map.Entry<String, JsonNode>> fields = stationsNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                stations.add(entry.getValue().asText());
            }
        } else if (stationsNode.isArray()) {
            // If it's already an array (as expected), process normally
            for (JsonNode station : stationsNode) {
                stations.add(station.asText());
            }
        }
        
        // Create and return the Train object
        Train train = new Train();
        // Set all properties 
        // train.setId(id);
        // train.setName(name);
        // train.setStations(stations);
        
        return train;
    }
} 