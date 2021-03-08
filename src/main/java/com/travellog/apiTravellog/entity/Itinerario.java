package com.travellog.apiTravellog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
//@Table(name="itinerario")
@javax.persistence.Entity(name = "itinerario")
public class Itinerario {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_itinerario")
	private int id_itinerario;
		
	@ManyToOne
	@JoinColumn(name = "fk_id_viaje", nullable = false, updatable = false)
	private Viaje fk_id_viaje;
	
	@Column(name="desc_corta")
	private String desc_corta;
    
    @Column(name="desc_larga")
	private String desc_larga;
	
    @Column(name="ruta")
	private String ruta;
    
    @Column(name="fecha")
    private Date fecha;

    // Getters y settes
    
	public int getId_itinerario() {
		return id_itinerario;
	}

	
	public Viaje getFk_id_viaje() {
		return fk_id_viaje;
	}



	public void setFk_id_viaje(Viaje fk_id_viaje) {
		this.fk_id_viaje = fk_id_viaje;
	}



	public void setId_itinerario(int id_itinerario) {
		this.id_itinerario = id_itinerario;
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Itinerario [id_itinerario=" + id_itinerario + ", fk_id_viaje=" + fk_id_viaje + ", desc_corta="
				+ desc_corta + ", desc_larga=" + desc_larga + ", ruta=" + ruta + ", fecha=" + fecha + "]";
	}
        
}
