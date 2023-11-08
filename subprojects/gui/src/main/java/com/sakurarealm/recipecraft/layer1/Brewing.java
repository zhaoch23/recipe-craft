package com.sakurarealm.recipecraft.layer1;

import com.sakurarealm.recipecraft.layer0.Interface;

@Override
public interface Brewing extends Interface {
    String state = "idle";

    @override
    public UIState identifyState() {
        return state;
    }
}