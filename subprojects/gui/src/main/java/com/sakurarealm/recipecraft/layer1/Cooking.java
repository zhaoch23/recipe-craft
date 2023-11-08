package com.sakurarealm.recipecraft.layer1;

import com.sakurarealm.recipecraft.layer0.Interface;

@Override
public interface Cooking extends Interface {

    String[] states = {"idle", "ready", "cooking", "done"};
    UIState uiState = new UIState("idle");
    Screen screen = new CookingScreen("idle");

    @override
    public UIState getState() {
        return this.uiState;
    }

    @override
    public UIState nextState() {

        if (this.uiState.getState() == "idle") {
            this.uiState.setState("ready");
        } else if (this.uiState.getState() == "ready") {
            this.uiState.setState("cooking");
        } else if (this.uiState.getState() == "cooking") {
            this.uiState.setState("done");
        } else if (this.uiState.getState() == "done") {
            this.uiState.setState("idle");
        }

        return this.uiState;
    }

    public Screen getScreen() {
        this.screen.update(uiState);
        return this.screen;
    }
    
}
