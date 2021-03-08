package com.travellog.apiTravellog.entity;

import java.util.Date;

import javax.persistence.*;

//@Entity
//@Table(name="viaje")
@javax.persistence.Entity(name = "viaje")
public class Viaje{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_viaje")
	private int id_viaje;
	
    @Column(name="desc_corta")
	private String desc_corta;
    
    @Column(name="desc_larga")
	private String desc_larga;
    
    @Column(name="fec_inicio")
	private Date fec_inicio;
    
    @Column(name="fec_fin")
    private Date fec_fin;
    
    @Column(name="participantes")
	private int participantes;
    
    @Column(name="medio_transporte")
	private String medio_transporte;

	public Viaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viaje(int id_viaje, String desc_corta, String desc_larga, 
				Date fec_inicio, Date fec_fin, int participantes,
				String medio_transporte) {
		super();
		this.id_viaje = id_viaje;
		this.desc_corta = desc_corta;
		this.desc_larga = desc_larga;
		this.fec_inicio = fec_inicio;
		this.fec_fin = fec_fin;
		this.participantes = participantes;
		this.medio_transporte = medio_transporte;
	}

	public int getViaje_id() {
		return id_viaje;
	}

	public void setViaje_id(int id_viaje) {
		this.id_viaje = id_viaje;
	}

	public String getDesc_corta() {
		return desc_corta;
	}

	public void setDesc_corta(String desc_corta) {
		this.desc_corta = desc_corta;
	}

	public String getDesc_larga() {
		return desc_larga;
	}

	public void setDesc_larga(String desc_larga) {
		this.desc_larga = desc_larga;
	}

	public Date getFec_inicio() {
		return fec_inicio;
	}

	public void setFec_inicio(Date fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public Date getFec_fin() {
		return fec_fin;
	}

	public void setFec_fin(Date fec_fin) {
		this.fec_fin = fec_fin;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public String getMedio_transporte() {
		return medio_transporte;
	}

	public void setMedio_transporte(String medio_transporte) {
		this.medio_transporte = medio_transporte;
	}

	@Override
	public String toString() {
		return "Viaje [viaje_id=" + id_viaje + ", desc_corta=" + desc_corta + ", desc_larga=" + desc_larga
				+ ", fec_inicio=" + fec_inicio + ", fec_fin=" + fec_fin + ", participantes=" + participantes
				+ ", medio_transporte=" + medio_transporte + "]";
	}
		
}
