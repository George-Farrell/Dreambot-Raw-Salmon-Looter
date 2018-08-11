package org.lord.strats;


import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.wrappers.items.GroundItem;
import org.lord.main.Core;
import org.lord.main.Node;


public class  LootingTask extends Node {

    private Area FISH_LOOTING = new Area(3102, 3424, 3109, 3434);
    private static int INV_COUNT;


    public LootingTask(Core c) {
        super(c);
    }

    @Override
    public boolean activate() {
        return !c.getInventory().isFull() && FISH_LOOTING.contains(c.getLocalPlayer());
    }

    @Override
    public int execute() {
        INV_COUNT = c.getInventory().count(331);

        GroundItem g = c.getGroundItems().closest(331);

        if (g != null){
            g.interact("Take");
            if (c.getInventory().count(331) != INV_COUNT){
                Core.fishLooted ++;
            }
        }
     return Calculations.random(750);
    }
}
