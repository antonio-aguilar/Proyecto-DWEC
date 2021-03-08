package com.travellog.apiTravellog.service;

import java.util.List;

import com.travellog.apiTravellog.entity.Viaje;

public interface ViajeService {

	 public List<Viaje> findAll();

    public Viaje findById(int id);

    public void save(Viaje viaje);

    public void deleteById(int id);
}
