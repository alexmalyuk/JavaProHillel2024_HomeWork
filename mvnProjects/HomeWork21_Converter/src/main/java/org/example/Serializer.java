package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.TextData;

public interface Serializer {
    TextData serialize(Object data) throws JsonProcessingException;

    Object deserialize(String content) throws JsonProcessingException;
}
