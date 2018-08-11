package org.lord.strats;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.map.Area;
import org.lord.main.Core;
import org.lord.main.Node;

public class WalkingTask extends Node {

    private Area FISH_LOOTING = new Area(3102, 3424, 3109, 3434);

    public WalkingTask(Core c) {
        super(c);
    }

    @Override
    public boolean activate() {
        return c.getInventory().isEmpty() && !FISH_LOOTING.contains(c.getLocalPlayer().getTile());
    }

    @Override
    public int execute() {
        if (!FISH_LOOTING.contains(c.getLocalPlayer().getTile())) {
            c.getWalking().walk(FISH_LOOTING.getRandomTile());
            MethodProvider.sleep(2750,7750);
        }
        return 0;
    }
}
