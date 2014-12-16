package com.github.loafer.spring;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    private ObjectMapper mapper;
    List<Map<String, String>> source;
    private String json = "[ { \"name\": \"张三\", \"key\": \"语文\", \"value\": \"95\" }, {\"name\":\"张三\", \"key\": \"数学\", \"value\": \"78\" }, { \"name\": \"李四\", \"key\": \"语文\", \"value\": \"83\" }, { \"name\": \"李四\", \"key\": \"数学\", \"value\": \"89\" }, { \"name\": \"李四\", \"key\": \"体育\", \"value\": \"100\" } ]";

    @Before
    public void setup() throws IOException {
        mapper = new ObjectMapper();
        source = mapper.readValue(json, new TypeReference<List<Map<String, String>>>(){});
    }

    @Test
    public void test() throws IOException {
        Map<String, Map<String, String>> tmp = new HashMap<String, Map<String, String>>();

        for(Map<String, String> map : source){
            if(tmp.containsKey(map.get("name"))){
                tmp.get(map.get("name")).put(map.get("key"), map.get("value"));
            }else{
                Map<String, String> m = new HashMap<String, String>();
                m.put("name", map.get("name"));
                m.put(map.get("key"), map.get("value"));
                tmp.put(map.get("name"), m);
            }
        }

        List<Map<String, String>> destination = new ArrayList<Map<String, String>>(tmp.values());
        System.out.println("destination: " + destination);
    }
}
