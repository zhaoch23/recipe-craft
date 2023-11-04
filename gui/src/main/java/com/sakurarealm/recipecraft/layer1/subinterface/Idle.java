package com.sakurarealm.recipecraft.layer1.subinterface;

import com.sakurarealm.recipecraft.layer0.UIState;
import com.sakurarealm.recipecraft.layer1.subinterface.Brewing;
import com.sakurarealm.recipecraft.layer1.subinterface.Cooking;
import com.sakurarealm.recipecraft.layer1.subinterface.Forging;

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
