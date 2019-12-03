/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.utils;

/**
 *
 * @author cesars
 */
public class TableData {

    private String Field;
    private String Type;
    private String Null;
    private String Key;
    private String Default;
    private String Extra;

    public TableData() {
    }

    public TableData(String Field, String Type, String Null, String Key, String Default, String Extra) {
        this.Field = Field;
        this.Type = Type;
        this.Null = Null;
        this.Key = Key;
        this.Default = Default;
        this.Extra = Extra;
    }

    public String getField() {
        return Field;
    }

    public void setField(String Field) {
        this.Field = Field;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getNull() {
        return Null;
    }

    public void setNull(String Null) {
        this.Null = Null;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public String getDefault() {
        return Default;
    }

    public void setDefault(String Default) {
        this.Default = Default;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String Extra) {
        this.Extra = Extra;
    }

}
