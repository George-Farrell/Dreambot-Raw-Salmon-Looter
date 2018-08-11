package org.lord.main;


import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.lord.strats.Banking;
import org.lord.strats.LootingTask;
import org.lord.strats.WalkingTask;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@ScriptManifest(category = Category.MONEYMAKING, name = "Fish Looter", author = "Lord", version = 1.2)
public class Core extends AbstractScript {

    private Node[] nodes;
    private long timeBegan;

    public static int fishLooted = 0;

    private final Color color1 = new Color(255, 0, 0);
    private final Font font1 = new Font("Georgia", 1, 11);

    @Override
    public void onStart(){
        timeBegan = System.currentTimeMillis();
        nodes = new Node[]{
        new LootingTask(this),
                new Banking(this),
                new WalkingTask(this)
        };
    }


    @Override
    public int onLoop() {
        for (Node node :nodes) {
            if (node.activate()){
                node.execute();
            }
        }

        log("No valid node");
        return Calculations.random(250,750);
    }

    public void onPaint(Graphics g1)
    {
        Graphics2D g = (Graphics2D)g1;

        long timeRan = System.currentTimeMillis() - this.timeBegan;
        g.setFont(font1);
        g.setColor(color1);
        g.drawString("Run Time: " + ft(timeRan), 363, 22);
        g.drawString("Fish Looted: " + fishLooted, 363, 43);

    }

    private String ft(long duration)
    {
        String res = "";
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                .toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                .toMinutes(duration));
        if (days == 0) {
            res = (hours + ":" + minutes + ":" + seconds);
        } else {
            res = (days + ":" + hours + ":" + minutes + ":" + seconds);
        }
        return res;
    }
}
