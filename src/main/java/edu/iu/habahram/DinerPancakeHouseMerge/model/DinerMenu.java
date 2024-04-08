package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

import java.util.Iterator;

public class DinerMenu extends Menu{


    public DinerMenu(String name, String description) {
        super(name, description);

        addItem("Vegetarian BLT dinner",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT dinner",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day lunch",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog lunch",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05);
        addItem("Steamed Veggies and Brown Rice dinner",
                "Steamed vegetables over brown rice", true, 3.99);
        addItem("Pasta dinner",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        add(menuItem);
    }


    // other menu methods here
}