public class Drink {
	String name, cate, brand;
	int price;

	Drink(String name, String cate, int price, String brand) {
		this.name = name;
		this.cate = cate;
		this.price = price;
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public String getCate() {
		return cate;
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

	public void setCate(String cate) {
		this.cate = cate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
