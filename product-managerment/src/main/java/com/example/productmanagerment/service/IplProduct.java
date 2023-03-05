package com.example.productmanagerment.service;
import com.example.productmanagerment.model.Product;
import java.util.ArrayList;
import java.util.List;

public class IplProduct implements IProduct {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "p1", "sam sung", 1000, "Korea", "new"));
        products.add(new Product(2, "p2", "oppo", 2000, "Taiwan", "new"));
        products.add(new Product(3, "p3", "iphone", 3000, "China", "new"));
        products.add(new Product(4, "p4", "xiaomi", 4000, "China", "new"));
        products.add(new Product(5, "p5", "VsMart", 1300, "Viet Nam", "new"));
        products.add(new Product(6, "p6", "BPhone", 1500, "Viet Nam", "new"));
    }

    @Override
    public List<Product> listProduct() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        products.set(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
