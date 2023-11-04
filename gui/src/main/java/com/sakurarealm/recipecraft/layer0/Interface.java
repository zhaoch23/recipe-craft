package com.sakurarealm.recipecraft.layer0;

public abstract interface Interface {

    String state = "idle";
    public default void identifyState(String objectName, String playerId) {

    }
    public default String getState() {
        return state;
    }

}