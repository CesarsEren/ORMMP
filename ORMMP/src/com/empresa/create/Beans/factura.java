package com.empresa.create.Beans;
public class factura{
    
	 private int  idfactura; 
 
	 private int  idcliente; 
 
	 private String  fechacompra; 
 
 
 	 public void setidfactura(int idfactura)
 	{this.idfactura = idfactura; 
 	 } 
	 public int getidfactura( ) { 
	 return this.idfactura; 
}	 public void setidcliente(int idcliente)
 	{this.idcliente = idcliente; 
 	 } 
	 public int getidcliente( ) { 
	 return this.idcliente; 
}	 public void setfechacompra(String fechacompra)
 	{this.fechacompra = fechacompra; 
 	 } 
	 public String getfechacompra( ) { 
	 return this.fechacompra; 
}}
