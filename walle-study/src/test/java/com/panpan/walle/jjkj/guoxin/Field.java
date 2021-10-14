package com.panpan.walle.jjkj.guoxin;

import lombok.Data;

@Data
public class Field{
    private String fieldType;

    private String fieldName;

    private String fieldDesc;

    public Field(String fieldType, String fieldName, String fieldDesc) {
        this.fieldType = convet(fieldType);
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
    }


    private String convet(String fieldType){

        return "String";
    }
}
