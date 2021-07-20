package com.panpan.walle.study.tmpuse.conditiondemo;

import java.util.Collection;
import java.util.stream.Collectors;

public class In2<K,V extends Collection<V>> extends AbstractOperation<K,V>{

    private final String beginStr = "(";
    private final String endStr = ")";

    public In2(K key, V value) {
        super(key, value);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("%s in ", key));
        stringBuffer.append(beginStr);

        Class<?> cls = value.getClass();
        stringBuffer.append("c1");
        stringBuffer.append(endStr);

       return stringBuffer.toString();
    }
}
