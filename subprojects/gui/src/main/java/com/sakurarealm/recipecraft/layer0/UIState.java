package com.sakurarealm.recipecraft.layer0;

public abstract class UIState {
    String current;

    public void uiState(String state) {
        this.current = state;
    }

    public void setState(String state) {
        this.current = state;
    }
    
}
