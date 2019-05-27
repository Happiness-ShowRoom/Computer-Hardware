package com.javarush.computer_hardware.controller;


import com.javarush.computer_hardware.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.javarush.computer_hardware.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService service;

    private int counter = 0;
    private boolean activator = false;
    private String findString = "";

    @Autowired
    public void setProductService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model, @PageableDefault(size = 10) Pageable pageable) {
        int quantity = getQuantity();
        Page<Product> pages = setPagesUp(pageable);

        model.addAttribute("counter", counter);
        model.addAttribute("quantity", quantity);

        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("products", pages.getContent());

        return "index";
    }

    @GetMapping("/sort")
    public String sortChoose() {
        this.activator = true;
        return "redirect:/";
    }

    @GetMapping("/new")
    public String addProduct() {
        return "operations/new";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam Integer quantity,
                             @RequestParam(value = "necessary", required = false) boolean isNecessary) {
        Product product = new Product(name, isNecessary, quantity);
        this.service.saveProduct(product);

        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchProduct() {
        return "operations/search";
    }

    @PostMapping("/find")
    public String findName(
            @RequestParam String name
    ) {
        this.counter = 3;
        this.findString = name;
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Integer id,
            Model model
    ) {
        Product product = this.service.getProductById(id);
        model.addAttribute("product", product);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String saveProduct(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam Integer quantity,
            @RequestParam(value = "necessary", required = false) boolean isNecessary
    ) {
        this.service.updateProduct(id, name, quantity, isNecessary);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        this.service.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/index")
    public String reset() {
        this.counter = 0;
        this.activator = false;
        return "redirect:/";
    }

    @GetMapping("/list")
    public String userList(Model model, Pageable pageable) {
        Page<Product> pages = service.findAllByOrderByName(pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("products", pages.getContent());
        return "/user/list";
    }

    private Page<Product> setPagesUp(Pageable pageable) {
        Page<Product> pages = null;

        if (activator) {
            this.counter = this.counter < 2 ? ++this.counter : 0;
            this.activator = false;
        }

        switch (this.counter) {
            case 0 :
                pages = this.service.findAllByOrderByName(pageable);
                break;
            case 1 :
                pages = this.service.findAllByNecessaryIsTrue(pageable);
                break;
            case 2 :
                pages = this.service.findAllByNecessaryIsFalse(pageable);
                break;
            case 3 :
                pages = this.service.findProductByName(pageable, findString);
                break;
        }
        return pages;
    }

    private int getQuantity() {
        List<Product> products = this.service.findAllByNecessaryIsTrueSorted();
        return products == null || products.size() == 0 ? 0 : products.get(0).getQuantity();
    }
}
