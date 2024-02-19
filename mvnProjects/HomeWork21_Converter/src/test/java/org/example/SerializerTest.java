package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.Format;
import org.example.dto.TextData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

class SerializerTest {

    @Tag(" ")
    class TestClass {
        public String key1 = "value 1";
        public String key2 = "value 2";
    }

//    private static final String TEXT_JSON = "{\n" +
//            "  \"key1\": \"value1\",\n" +
//            "  \"key2\": \"value2\"\n" +
//            "}";
//    private static final String TEXT_XML = "{\n" +
//            "  \"key1\": \"value1\",\n" +
//            "  \"key2\": \"value2\"\n" +
//            "}";
//    private static final String TEXT_YAML = "{\n" +
//            "  \"key1\": \"value1\",\n" +
//            "  \"key2\": \"value2\"\n" +
//            "}";

    private final TestClass testObject = new TestClass();

    private static Stream<Arguments> paramsGenerator() {
        return Stream.of(
                Arguments.of(Format.JSON),
                Arguments.of(Format.YAML),
                Arguments.of(Format.XML)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsGenerator")
    void serialize(Format format) throws JsonProcessingException {

        Serializer serializer = switch (format) {
            case JSON -> new SerializerJson();
            case YAML -> new SerializerYaml();
            case XML -> new SerializerXml();
        };

        TextData td = serializer.serialize(testObject);
        Assertions.assertEquals(format, td.getFormat());

        var testObject2 = (Map) serializer.deserialize(td.getContent());
        Assertions.assertEquals(testObject.key1, testObject2.get("key1"));
        Assertions.assertEquals(testObject.key2, testObject2.get("key2"));
    }

    @Test
    void deserializeJson() throws JsonProcessingException {

        Serializer ser = new SerializerJson();
        var testObject = (Map) ser.deserialize("{\n" +
                "  \"key1\" : \"value 1\",\n" +
                "  \"key2\" : \"value 2\"\n" +
                "}");

        Assertions.assertEquals("value 1", testObject.get("key1"));
        Assertions.assertEquals("value 2", testObject.get("key2"));
    }

    @Test
    void deserializeYaml() throws JsonProcessingException {

        Serializer ser = new SerializerYaml();
        var testObject = (Map) ser.deserialize("---\n" +
                "key1: value 1\n" +
                "key2: value 2\n");

        Assertions.assertEquals("value 1", testObject.get("key1"));
        Assertions.assertEquals("value 2", testObject.get("key2"));
    }

    @Test
    void deserializeXml() throws JsonProcessingException {

        String textXML = "<root>\n" +
                "\t<key1>value 1</key1>\n" +
                "\t<key2>value 2</key2>\n" +
                "</root>";
        Serializer ser = new SerializerXml();
        var testObject = (Map) ser.deserialize(textXML);

        Assertions.assertEquals("value 1", testObject.get("key1"));
        Assertions.assertEquals("value 2", testObject.get("key2"));
    }

    @Test
    @Disabled
    void TestXML() throws JsonProcessingException {
        Serializer ser = new SerializerXml();
        TextData td = ser.serialize(testObject);
        System.out.println(td.getContent());

        Object data = ser.deserialize(td.getContent());
        System.out.println(data);
    }

    @Test
    @Disabled
    void TestYAML() throws JsonProcessingException {
        Serializer ser = new SerializerYaml();
        TextData td = ser.serialize(testObject);
        System.out.println(td.getContent());

        Object data = ser.deserialize(td.getContent());
        System.out.println(data);
    }
}