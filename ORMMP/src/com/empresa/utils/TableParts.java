package com.empresa.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesars
 */
public class TableParts {

    String packagename;
    String classname;
    String atributes;
    String metodos;
    public void setMetodos(String metodos) {
		this.metodos = metodos;
	}
    public String getMetodos() {
		return metodos;
	}

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getAtributes() {
        return atributes;
    }

    public void setAtributes(String atributes) {
        this.atributes = atributes;
    }

    public TableParts() {
    }

    public TableParts(String packagename, String classname, String atributes) {
        this.packagename = packagename;
        this.classname = classname;
        this.atributes = atributes;
    }

    @Override
    public String toString() {
        return "TableParts{" + "packagename=" + packagename + ", classname=" + classname + ", atributes=" + atributes + '}';
    }

}
