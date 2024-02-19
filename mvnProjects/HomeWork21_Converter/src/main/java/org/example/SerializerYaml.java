package org.example;

import org.example.dto.Format;
import org.example.dto.TextData;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SerializerYaml implements Serializer {
    @Override
    public TextData serialize(Object data) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        options.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);

        Yaml yaml = new Yaml(options);
        String content = yaml.dump(data);
        content = Arrays.stream(content.split("\n"))
                .filter(s -> !(s.startsWith("!!") && s.endsWith("Class")))
                .collect(Collectors.joining("\n"));

        return new TextData(Format.YAML, content);
    }

    @Override
    public Object deserialize(String content) {
        Yaml yaml = new Yaml();
        return yaml.load(content);
    }

}
