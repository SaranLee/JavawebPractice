package demo.domain;

public class ProductExtend {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductExtend{" +
                "category=" + category +
                '}';
    }
}
