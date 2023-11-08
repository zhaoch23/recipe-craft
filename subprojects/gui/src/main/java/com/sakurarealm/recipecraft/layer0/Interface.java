package com.sakurarealm.recipecraft.layer0;

public abstract interface Interface {

    String[] states;

    public String[] getStates() {
        return this.states;
    }

    public default void getState() {

    }

    public default void nextState() {
    }

}