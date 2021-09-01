package com.example.snakeyaml.entity;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class ParseYaml {
    public void parseyaml(InputStream inputStream) {
        Yaml yaml = new Yaml();
        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis =
                new FileInputStream("./src/main/resources/static/customer.yaml");

        ParseYaml parseYaml = new ParseYaml();
        parseYaml.parseyaml(fis);


    }
}
