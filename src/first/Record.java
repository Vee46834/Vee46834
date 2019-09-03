package first;

public class Record {
	private String foodName;
	private int soldPrice;

	public Record(String foodName, int soldPrice) {
		super();
		this.foodName = foodName;
		this.soldPrice = soldPrice;
	}

	public String toString() {
		return "Menu : " + foodName + " sold in " + soldPrice + " THB";
	}

	public String getFoodName() {
		return foodName;
	}

	public int getSoldPrice() {
		return soldPrice;
	}

}
