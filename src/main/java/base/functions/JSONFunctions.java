package main.java.base.functions;


import io.restassured.path.json.JsonPath;

public interface JSONFunctions {
    public default String getJSONValue(String json, String key) {
        return JsonPath.from(json).get(key);
    }
}
