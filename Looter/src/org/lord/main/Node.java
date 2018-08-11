package org.lord.main;

public abstract class Node {
    protected Core c;

    public Node(Core main){
        this.c = main;
    }

    public abstract boolean activate();

    public abstract int execute();
}
