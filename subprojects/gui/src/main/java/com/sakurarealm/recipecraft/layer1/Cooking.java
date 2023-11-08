package com.sakurarealm.recipecraft.layer1;

import com.sakurarealm.recipecraft.layer0.Interface;
import com.sakurarealm.recipecraft.layer0.UIState;
import com.sakurarealm.recipecraft.layer1.Screen;

@Override
public interface Cooking extends Interface {

    String[] states = {"idle", "ready", "cooking", "done"};
    UIState uiState = new UIState("idle");
    Screen screen = new CookingScreen("idle");

    @override
    public static UIState getState() {
        return uiState;
    }

    @override
    public static UIState nextState() {

        if (uiState.getState() == "idle") {
            uiState.setState("ready");
        } else if (uiState.getState() == "ready") {
            uiState.setState("cooking");
        } else if (uiState.getState() == "cooking") {
            uiState.setState("done");
        } else if (uiState.getState() == "done") {
            uiState.setState("idle");
        }

        return uiState;
    }

    public static Screen getScreen() {
        screen.update(uiState);
        return screen;
    }
    
}
