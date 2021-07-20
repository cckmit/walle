package com.panpan.walle.study.tmpuse.conditiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionBuilder {

    public static void main(String[] args) {
        String result =
                new ConditionBuilder()
                .add(new Equals("a", "a1"))
                .add(new NotEquals("b","b1"))
                .add(new In2("c", Arrays.asList("c1","c2", "c3")))
                .builder();
        System.out.println(result);
    }
    private List<Operation> operations = new ArrayList<>();

    public ConditionBuilder add(Operation operation){
        operations.add(operation);
        return this;
    }

    public String builder(){
        StringBuffer stringBuffer = new StringBuffer();
        String AND = " and ";
        for (Operation operation: operations){
            stringBuffer.append(AND + operation);
        }
        return stringBuffer.toString();
    }
}
