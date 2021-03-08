package com.travellog.apiTravellog.dao;

import java.util.List;

import com.travellog.apiTravellog.entity.Viaje;

public interface ViajeDAO {

    public List<Viaje> findAll();

    public Viaje findById(int id);

    public void save(Viaje viaje);

    public void deleteById(int id);

}
