package org.samples.springbootrestsample.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.samples.springbootrestsample.domain.Product;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("products")
@RequestMapping("/products")
public class ProductController extends BaseController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	
	Product create(@RequestBody Product product) {

		product.add(linkTo(methodOn(ProductController.class).get(product.getProductId())).withSelfRel());
		return product;

	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	Product get(@PathVariable("productId") UUID productId) {

		Product product = new Product();
		product.setProductId(productId);
		product.setName("MyProduct");
		product.add(linkTo(methodOn(ProductController.class).get(productId)).withSelfRel());

		return product;

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	List<Product> getAll() {

		Product product = new Product();
		product.setProductId(UUID.randomUUID());
		product.setName("MyProduct1");
		product.add(linkTo(methodOn(ProductController.class).get(product.getProductId())).withSelfRel());

		Product product2 = new Product();
		product2.setProductId(UUID.randomUUID());
		product2.setName("MyProduct2");
		product2.add(linkTo(methodOn(ProductController.class).get(product2.getProductId())).withSelfRel());

		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);

		return products;
	}

	@RequestMapping(value = "{productId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	Product putme(HttpServletResponse response, @PathVariable("productId") UUID productId,
			@RequestBody Product modified) {

		return modified;

	}

	@RequestMapping(value = "{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(HttpServletResponse response, @PathVariable("productId") UUID productId) {

	}

}
