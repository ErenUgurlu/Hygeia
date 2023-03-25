package com.backend.hygeia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import com.backend.hygeia.entities.Category;
import com.backend.hygeia.entities.Notice;
import com.backend.hygeia.entities.Product;
import com.backend.hygeia.repositories.ProductRepository;
import com.backend.hygeia.services.CategoryService;
import com.backend.hygeia.services.NoticeService;
import com.backend.hygeia.services.ProductService;

import java.util.*;

@Controller
public class HomePageController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/")
	String getProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        List<Category> categoryList = categoryService.getAllCategories();
        List<Notice> noticeList = noticeService.getAllNotices();
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("noticeList", noticeList);
        //Return edilen isim sayfanın ismidir index.html ye götürür buraya gelen istekleri
        return "index";
	}
	@GetMapping("/login")
	String getProduct() {
        return "login";
	}
	@GetMapping("/OpenRedirectForm")
	String getProducts() {
        return "OpenRedirectForm";
	}
	@GetMapping("/register")
	String getProduc() {
        return "register";
	}
	@GetMapping("/OpenRedirect")
	String getProdu() {
        return "OpenRedirect";
	}
	@GetMapping("/ContactUS")
	String contactus() {
		return "ContactUs";
	}
	
	@GetMapping("/sepetten-sil")
	public RedirectView sepettenSil() {
	    // Sepet işlemleri yapılır
	    // ...
	    // Yeniden yönlendirme yapılır
	    return new RedirectView("/");
	}
}
