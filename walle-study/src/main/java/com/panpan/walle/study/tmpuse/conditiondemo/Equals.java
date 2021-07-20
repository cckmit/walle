package com.panpan.walle.study.tmpuse.conditiondemo;

public class Equals extends AbstractOperation{
    public Equals(Object key, Object value) {
        super(key, value);
    }

    @Override
    public String toString() {
        return String.format(" %s = %s ", key, value);
    }
}
