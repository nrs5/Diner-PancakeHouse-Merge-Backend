package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinerMenuInterator implements Iterator<MenuItem> {
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuInterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more items to iterate over.");
        }
        return menuItems[position++];
    }

    // Optional: Implement remove() if needed
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}

