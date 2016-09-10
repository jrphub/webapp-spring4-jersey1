package org.geobricks.core;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
@Component
public class HelloWorldCore implements IHelloWorld{

	private Gson g;

    public HelloWorldCore() {
        this.setG(new Gson());
    }

    public String sayHello(String name) {
        return "Hello " + name + "!";
    }

    public String sayHelloJSON(String name) {
        Map<String, String> m = new HashMap<>();
        m.put("hello", name);
        return this.getG().toJson(m);
    }

    public Gson getG() {
        return g;
    }

    public void setG(Gson g) {
        this.g = g;
    }

}
