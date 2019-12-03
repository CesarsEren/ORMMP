package com.empresa.utils;

import java.util.List;

public class ItemsForCRUD {

	String Entity; 
	List<String> listatributos;

	public List<String> getListatributos() {
		return listatributos;
	}

	public void setListatributos(List<String> listatributos) {
		this.listatributos = listatributos;
	}

	public String getEntity() {
		return Entity;
	}

	public void setEntity(String entity) {
		Entity = entity;
	} 

}
