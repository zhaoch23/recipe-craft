package com.sakurarealm.recipecraft.layer0;

public abstract class UIState {
    String current;

    public static void uiState(String state) {
        this.current = state;
    }

    public static void setState(String state) {
        this.current = state;
    }
    
}
