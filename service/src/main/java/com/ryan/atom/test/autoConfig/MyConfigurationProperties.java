package com.ryan.atom.test.autoConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myTestConfiguration")
public class MyConfigurationProperties {

    private Integer propertyA;

    private String propertyB;

    public Integer getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(Integer propertyA) {
        this.propertyA = propertyA;
    }

    public String getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(String propertyB) {
        this.propertyB = propertyB;
    }
}
