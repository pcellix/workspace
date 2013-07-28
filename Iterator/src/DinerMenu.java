
public class DinerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[6];		
	}
	
	public void addItem(String name, String description) {
		MenuItem menuItem = new MenuItem(name, description);
		if(numberOfItems >=  MAX_ITEMS) {
			System.err.println("Error");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	public MenuItem[] getMenuItems() {
		return menuItems;
	}
		
		
	}

}
