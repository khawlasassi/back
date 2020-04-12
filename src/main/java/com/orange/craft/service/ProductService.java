package com.orange.craft.service;

import com.orange.craft.entity.Product;
import com.orange.craft.repository.IproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IproductRepository iproductRepository;

    public List<Product> getAllProduct() {
        return iproductRepository.findAll();
    }

    public Product getProductById(long productId) throws ResourceNotFoundException {

        return iproductRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit non trouvé avec id :" + productId));

    }

    public Product addProduct(Product product) {
        return iproductRepository.save(product);
    }

    public Product updateProduct(Product productUpdated) {
        Product product = iproductRepository.findById(productUpdated.getId())
                .orElseThrow(() ->new ResourceNotFoundException("Produit non trouvé avec id " + productUpdated.getId()));

        product.setIntitule(productUpdated.getIntitule());
        product.setPrix(productUpdated.getPrix());
        product.setImage(productUpdated.getImage());

        return iproductRepository.save(product);
    }

    public void deleteProduct(long id) {
        Product produit = iproductRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Produit non trouvé avec id " + id));

        iproductRepository.delete(produit);
    }


}
