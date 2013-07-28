import java.util.ArrayList;


public class PancakeHouseMenu {
	ArrayList menuItems;
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList();
		
	}
	
	public void addItem(String name, String description) {
		MenuItem menuItem = new MenuItem(name, description);
		menuItems.add(menuItem);
	}
	
	public ArrayList getMenuItems() {
		return this.menuItems;
	}
}
