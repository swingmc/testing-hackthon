import java.util.List;
public class InventoryService {
    boolean updateInventory(List<Item> items) {
        // Code to update the inventory
        if (items.isEmpty()) {
            return false;
        }
        // Check if the item is in stock
        for (Item item : items) {
            if (item.getQuantity() <= 0) {
                return false;
            }
        }
        return true;
    }
}
