package demo.domain;

import java.util.List;

public class CategoryExtend {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryExtend{" +
                "products=" + products +
                '}';
    }
}
