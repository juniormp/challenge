package com.challenge.buider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.challenge.entity.Image;
import com.challenge.entity.Product;

public class ProductBuilder {

    private String name;
    private Set<Image> images;
    private Product parent;

    public ProductBuilder(String name) {
        this.name = name;
    }

    public ProductBuilder images(Image... images) {
        this.images = new HashSet<>(Arrays.asList(images));
        return this;
    }

    public Product build(){
        Product product = new Product(name);
        product.setImages(images);
        product.setParent(parent);
        return product;
    }

    public ProductBuilder parent(Product parent) {
        this.parent = parent;
        return this;
    }
}
