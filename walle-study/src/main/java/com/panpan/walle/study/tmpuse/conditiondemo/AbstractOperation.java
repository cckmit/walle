package com.panpan.walle.study.tmpuse.conditiondemo;

public abstract class AbstractOperation<K, V> implements Operation{
    protected K key;
    protected V value;

    public AbstractOperation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
