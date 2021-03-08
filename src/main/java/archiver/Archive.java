package archiver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Archive implements Serializable {
    private List<Item> itemList;

    public Archive() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }
    public int getItemsNumber()
    {
        return itemList.size();
    }
}
