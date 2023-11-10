package pe.company.service;

import pe.company.model.Conyuge;
import pe.company.model.Tecnologia;

import java.util.Collection;

public interface TecnologiaService {
    public abstract void insert(Tecnologia tecnologia);
    public abstract void update(Tecnologia tecnologia);
    public abstract void delete(int tecnologiaId);
    public abstract Tecnologia findById(int tecnologiaId);
    public abstract Collection<Tecnologia> findAll();
}
