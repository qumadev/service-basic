package pe.company.service;

import pe.company.model.Conyuge;

import java.util.Collection;

public interface ConyugeService {

    public abstract void insert(Conyuge conyuge);
    public abstract void update(Conyuge conyuge);
    public abstract void delete(int conyugeId);
    public abstract Conyuge findById(int conyugeId);
    public abstract Collection<Conyuge> findAll();
}
