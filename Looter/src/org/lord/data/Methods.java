package org.lord.data;

import org.dreambot.api.methods.map.Area;

public class Methods {


    /**
     * The area on the map to loot in.
     */
    private Area lootArea;


    /**
     * Returns the looting area.
     */
    public Area getLootArea() {
        return lootArea;
    }

    /**
     * Sets the looting area.
     */
    public void setLootArea(Area lootArea) {
        this.lootArea = lootArea;
    }
}
