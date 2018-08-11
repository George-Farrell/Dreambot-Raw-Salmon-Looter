package org.lord.strats;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.map.Area;
import org.lord.main.Core;
import org.lord.main.Node;

public class Banking extends Node {

    private Area BANK = new Area(3094, 3488, 3092, 3496);

    public Banking(Core c) {
        super(c);
    }

    @Override
    public boolean activate() {
        return c.getInventory().isFull();
    }

    @Override
    public int execute() {
        if (!BANK.contains(c.getLocalPlayer().getTile())) {
            c.getWalking().walk(BANK.getRandomTile());
            MethodProvider.sleep(1750,7800);
        }
        if (BANK.contains(c.getLocalPlayer().getTile())) {
            c.getBank().open();
            c.getBank().depositAllItems();
            c.getBank().close();
        }
        return 0;
    }
}
