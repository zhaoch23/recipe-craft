package com.sakurarealm.recipecraft.layer2;

public class ForgingScreen extends Screen {
    
    UIState screen;
    @Override
    public static void Screen(UIState state) {
        this.screen = state;
    }

    Override
    public static void update(UIState state) {
        this.screen = state;
    }
    
}

