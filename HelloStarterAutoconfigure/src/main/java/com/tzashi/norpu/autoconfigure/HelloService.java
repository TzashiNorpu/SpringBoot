package com.tzashi.norpu.autoconfigure;

public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloTzashiNorpu(String name) {
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }
}