package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.dto.Format;
import org.example.dto.TextData;

import java.util.Map;

public class SerializerXml implements Serializer {
    @Override
    public TextData serialize(Object data) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xmlContent;
        xmlContent = xmlMapper.writeValueAsString(data);
        return new TextData(Format.XML, xmlContent);
    }

    @Override
    public Object deserialize(String content) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(content);

        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.convertValue(jsonNode, Map.class);
    }

}
