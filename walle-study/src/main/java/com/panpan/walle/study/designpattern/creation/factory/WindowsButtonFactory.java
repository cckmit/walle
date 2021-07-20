package com.panpan.walle.study.designpattern.creation.factory;

public class WindowsButtonFactory implements ButtonFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
