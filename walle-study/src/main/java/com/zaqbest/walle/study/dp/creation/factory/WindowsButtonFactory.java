package com.zaqbest.walle.study.dp.creation.factory;

public class WindowsButtonFactory implements ButtonFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
