package com.panpan.walle.study.tmpuse.conditiondemo;

public class NotEquals extends AbstractOperation{
    public NotEquals(Object key, Object value) {
        super(key, value);
    }

    @Override
    public String toString() {
        return String.format(" %s <> %s ", key, value);
    }
}
