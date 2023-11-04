package com.sakurarealm.recipecraft.layer1.subinterface;

import com.sakurarealm.recipecraft.layer0.UIState;

public class Idle extends UIState {

    public void uiState(Object object) {
        if (object instanceof Brewing) {
            Brewing brewing = (Brewing) object;
        } else if (object instanceof Cooking) {
            Cooking cooking = (Cooking) object;
        } else if (object instanceof Forging) {
            Forging forging = (Forging) object;
        }

    }

    public void draw() {
        
    }
    
}
