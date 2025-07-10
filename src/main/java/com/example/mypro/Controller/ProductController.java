package com.example.mypro.Controller;

// import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @GetMapping("/products")
    public String getProducts() {
        return "product";
}
}