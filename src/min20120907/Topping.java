package min20120907;

public class Topping {
    int price;
    String name, category, brand;

    Topping(String name, String category, int price, String brand) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
