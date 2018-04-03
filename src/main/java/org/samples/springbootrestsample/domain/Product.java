package org.samples.springbootrestsample.domain;

import java.util.UUID;

import org.springframework.hateoas.ResourceSupport;

public class Product extends ResourceSupport {

    private UUID productId;
    private String name;

    public UUID getProductId() {
	return productId;
    }

    public void setProductId(UUID productId) {
	this.productId = productId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
