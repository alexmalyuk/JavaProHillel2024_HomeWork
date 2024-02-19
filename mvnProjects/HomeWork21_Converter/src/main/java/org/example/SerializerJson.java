package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Format;
import org.example.dto.TextData;

public class SerializerJson implements Serializer {
    @Override
    public TextData serialize(Object data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        return new TextData(Format.JSON, content);
    }

    @Override
    public Object deserialize(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Object.class);
    }
}
