package first;

import java.util.*;

public class ICanteen {
	public static List<Store> stores = new ArrayList<Store>();
	public static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			// FILL CODE
			printMain();
			System.out.print("Select a program to do : ");

			int key = kb.nextInt();
			switch (key) {
			case 1:
				System.out.println("---------------------------");
				addStoreHandle();
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				manageStoreHandle();
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				buyFoodHandle();
				System.out.println("---------------------------");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid input!!");
			}

		}

	}

	private static boolean addStoreHandle() {
		System.out.print("Store Name : ");
		String storeName = kb.nextLine();
		// FILL CODE
		for (int i = 0; i < stores.size(); ++i) {
			if (stores.get(i).getName().equals(storeName)) {
				return false;
			}
		}
		Store store = new Store(storeName);
		stores.add(store);

		System.out.println("The store named " + storeName + " was added!");
		return true;
	}

	private static boolean manageStoreHandle() {
		// FILL CODE
		if (stores.isEmpty()) {
			System.out.println("Please add store first!!");
			return false;
		}
		showStores();
		System.out.print("Please select store :");
		int storeNumber = kb.nextInt();
		String xxx = kb.nextLine();
		stores.get(storeNumber - 1).manageProcessHandle();
		return true;
	}

	private static boolean buyFoodHandle() {
		// FILL CODE
		if (stores.isEmpty()) {
			System.out.println("Please add store first!!");
			return false;
		}
		showStores();
		System.out.print("Please select store :");
		int storeNumber = kb.nextInt();
		stores.get(storeNumber - 1).sellProcessHandle();
		return true;
	}

	public static void printMain() {
		System.out.println("=========== Main Menu ==========");
		System.out.println("What to do?");
		System.out.println("1. Add Store");
		System.out.println("2. Manage Store");
		System.out.println("3. Buy food");
		System.out.println("4. Exit program");
	}

	public static boolean showStores() {
		// FILL CODE
		if (stores.isEmpty()) {
			System.out.println("Please add store first!!");
			return false;
		}
		System.out.println("Here are all stores");
		for (int i = 0; i < stores.size(); ++i) {
			System.out.println("[" + (i + 1) + "] " + stores.get(i).getName());
		}
		return true;
	}

}
