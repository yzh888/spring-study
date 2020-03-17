package com.soft1851.ioc.entity;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/12
 * @Version 1.0
 */
public class Phone {
    private String name;
    private Double price;

    public Phone() {
    }

    public Phone(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
