package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class DinerMenuInterator implements Iterator{
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuInterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
