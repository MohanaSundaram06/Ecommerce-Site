package com.ecommerce.shopping.controller;

import com.ecommerce.shopping.entity.Cart;
import com.ecommerce.shopping.entity.Product;
import com.ecommerce.shopping.service.CategoryService;
import com.ecommerce.shopping.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
@RequestMapping("pandas/product")
public class ProductController {

    @Autowired
    private ProductService theProductService;

    @Autowired
    private CategoryService theCategoryService;

    @GetMapping("/manage-products")
    public String showProduts(Model model) {

        model.addAttribute("theProduct", theProductService.productList());
        model.addAttribute("theCategory", theCategoryService.categoryList());

        return "product/products-list";
    }

    @GetMapping("/addProduct")
    public String showProductForm(Model model) {

        model.addAttribute("theProduct", new Product());

        model.addAttribute("categoryList", theCategoryService.categoryList());

        return "product/product-form";
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") int id) throws IOException, SQLException {

        Product image = theProductService.getProduct(id);
        byte[] imageBytes = null;
        imageBytes = image.getImage().getBytes(1, (int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
    }

    @PostMapping("/saveProduct")
    public String addProduct(HttpServletRequest request, @ModelAttribute("theProduct") Product product, @RequestParam("productImage") MultipartFile file) throws IOException, SQLException {

        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        product.setImage(blob);
        theProductService.addProduct(product);

        return "redirect:manage-products";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int id) {

        theProductService.deleteProduct(theProductService.getProduct(id));
        
        return "redirect:manage-products";
    }

    @GetMapping("/editProduct")
    public String editProduct(@RequestParam("productId") int id, Model model) {

    	model.addAttribute("categoryList", theCategoryService.categoryList());
        model.addAttribute("theProduct", theProductService.getProduct(id));

        return "/product/product-form";

    }

   
}














