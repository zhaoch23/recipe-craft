package com.sakurarealm.recipecraft.layer2;

import com.sakurarealm.recipecraft.layer0.UIState;
import com.sakurarealm.recipecraft.layer1.Screen;

public class ForgingScreen extends Screen {
    
    static UIState screen;
    @Override
    public static void Screen(UIState state) {
        screen = state;
    }

    @Override
    public void update(UIState state) {
        screen = state;
    }
    
}

