package dto;

import java.io.Serializable;

public class DTOBackLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String actividad;
	private String detalle1;
	private String detalle2;
	private String detalle3;
	private String fecha;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getDetalle1() {
		return detalle1;
	}
	public void setDetalle1(String detalle1) {
		this.detalle1 = detalle1;
	}
	public String getDetalle2() {
		return detalle2;
	}
	public void setDetalle2(String detalle2) {
		this.detalle2 = detalle2;
	}
	public String getDetalle3() {
		return detalle3;
	}
	public void setDetalle3(String detalle3) {
		this.detalle3 = detalle3;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
