package pe.company.service;

import pe.company.model.Conyuge;
import pe.company.model.Taller;

import java.util.Collection;

public interface TallerService {
    public abstract void insert(Taller taller);
    public abstract void update(Taller taller);
    public abstract void delete(int tallerId);
    public abstract Taller findById(int tallerId);
    public abstract Collection<Taller> findAll();
}
