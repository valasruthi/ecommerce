package com.kurtas.designerkurtas.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.kurtas.designerkurtas.model.ProductDetails;

@Component
public interface ProductDao {
	public boolean newProductData(ProductDetails pdt);
    public  ProductDetails getPtid(int id);
    public List<ProductDetails> retrieveAllProducts();
    public boolean updateProdData(ProductDetails pdts);
    public boolean deleteProducts(ProductDetails pd);
}
