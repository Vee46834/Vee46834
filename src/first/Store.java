package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
	private String name;
	private int totalSales;
	private List<Record> records;
	private List<Menu> menus;

	public Store(String name) {
		super();
		this.name = name;
		totalSales = 0;
		records = new ArrayList<Record>();
		menus = new ArrayList<Menu>();
	}

	public void showAllMenu() {
		for (int i = 0; i < menus.size(); ++i) {
			Menu menu = new Menu(menus.get(i).getName(), menus.get(i).getPrice());
			menu.toString();
		}

	}

	public boolean addMenu(Menu menu) {
		for (int i = 0; i < menus.size(); ++i) {
			if (menus.get(i).getName().equals(menu.getName())) {
				return false;
			}
		}

		menus.add(menu);
		return true;
	}

	public void addRecord(Record record) {
		records.add(record);
	}

	public void sell(Menu menu, boolean isSpecial) {
		// FILL CODE
		boolean found = false;
		for (int i = 0; i < menus.size(); ++i) {
			if (menus.get(i).getName().equals(menu.getName())) {
				found = true;
			}
		}
		if (!found) {
			System.out.println("Please select valid menu.");
		} else {
			int price;
			if (isSpecial) {
				price = menu.getSpecialPrice();
			} else {
				price = menu.getPrice();
			}
			this.totalSales += price;
			Record record = new Record(menu.getName(), price);
			addRecord(record);
			System.out.println("Thank you for buying " + menu.getName() + " " + price + " Bath");
		}
	}

	public void showRecord() {
		for (int i = 0; i < records.size(); ++i) {
			System.out.println(records.get(i).toString());
		}
	}

	public void sellProcessHandle() {
		// FILL CODE
		System.out.println("---------------------------");
		System.out.println("Welcome to " + this.name);
		System.out.println("---------------------------");
		if (menus.isEmpty()) {
			System.out.println("Please add menu first");
		} else {
			for (int i = 0; i < menus.size(); ++i) {
				System.out.println("[" + (i + 1) + "] " + menus.get(i));
			}
			System.out.print("Please select menu : ");
			Scanner sc = new Scanner(System.in);
			int nu = sc.nextInt();
			String xxx = sc.nextLine();
			System.out.print("Upgrade to special ? (Y/N) :");
			String YorN = sc.nextLine();
			if (YorN.equals("Y")) {
				sell(menus.get(nu - 1), true);
			} else if (YorN.equals("N")) {
				sell(menus.get(nu - 1), false);
			}

		}
	}

	public void manageProcessHandle() {
		System.out.println("---------------------------");
		System.out.println("Welcome to " + this.name);
		System.out.println("---------------------------");
		System.out.println("1. Add menu");
		System.out.println("2. Show summary");
		System.out.println("Select a program to do : ");
		Scanner kb = new Scanner(System.in);
		int choose = kb.nextInt();
		String xxx = kb.nextLine();
		if (choose == 1) {
			addMenuHandle();
		} else if (choose == 2) {
			showSummary();
		}

	}

	private void addMenuHandle() {
		// FILL HERE
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter menu name :");
		String menuName = sc.nextLine();
		boolean found = false;
		for (int i = 0; i < menus.size(); i++) {
			if (menus.get(i).getName().equals(menuName)) {
				found = true;
			}
		}
		if (!found) {
			System.out.println("Please enter price :");
			int price = sc.nextInt();
			Menu menu = new Menu(menuName, price);
			addMenu(menu);
			System.out.println("New menu " + menuName + " added!");
		}
	}

	private void showSummary() {
		// FILL CODE
		System.out.println("Total Sales : " + this.totalSales);
		showRecord();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
