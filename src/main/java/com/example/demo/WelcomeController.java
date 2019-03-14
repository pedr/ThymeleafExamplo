package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {

	private List<Product> allProducts = new ArrayList<>();

    @GetMapping("/product")
    public String returnThings(Model model) {    	
    	model.addAttribute("products", this.allProducts);
    	model.addAttribute("product", new Product());
    	return "product";
    }
	
	@PostMapping("/product")
    String acceptThings(@ModelAttribute Product product) {
    	this.allProducts.add(product);
    	return "redirect:/product";
    }
    
    
    @GetMapping("/product/sum")
    public String sumProducts(Model model) {
    	
    	double sum = 0;
    	for (Product product : this.allProducts) {
    		sum += Double.parseDouble(product.getPrice());
    	}
    	
    	model.addAttribute("total", sum);
    	
    	return "productSum";
    }
    

}