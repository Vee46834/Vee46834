package first;

public class Menu {
	private String name;
	private int price;
	private int specialPrice;

	public Menu(String name, int price) {
		super();
		this.name = name;
		setPrice(price);
	}

	public String toString() {
		return name + " Price : " + price + " (special " + specialPrice + ")";
	}

	public void setPrice(int price) {
		if (price < 0) {
			price = 0;
		} else if (price > 200) {
			price = 200;
		}
		this.price = price;
		setSpecialPrice();
	}

	private void setSpecialPrice() {
		if (price <= 50) {
			specialPrice = price + 5;
		} else if (price <= 100) {
			specialPrice = price + 10;
		} else if (price > 100) {
			specialPrice = price + 20;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

}
