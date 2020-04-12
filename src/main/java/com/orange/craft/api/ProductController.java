package com.orange.craft.api;

import com.orange.craft.entity.Product;
import com.orange.craft.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/" ,method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }


    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") long id)  {
        return productService.getProductById(id);

    }

    @RequestMapping(value ="/",method = RequestMethod.POST)
    public Product AddProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product) {
        product.setId(id);
        return  productService.updateProduct(product);
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") long id)  {
        productService.deleteProduct(id);

    }
}
