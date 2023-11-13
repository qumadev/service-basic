package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Taller;
import pe.company.repository.TallerRepository;

import java.util.Collection;

@Service
public class TallerServiceImpl implements TallerService{
    @Autowired
    private TallerRepository tallerRepository;

    @Override
    @Transactional
    public void insert(Taller taller) {
        tallerRepository.save(taller);
    }

    @Override
    @Transactional
    public void update(Taller taller) {
        tallerRepository.save(taller);
    }

    @Override
    @Transactional
    public void delete(int tallerId) {
        tallerRepository.deleteById(tallerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Taller findById(int tallerId) {
        return tallerRepository.findById(tallerId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Taller> findAll(){
        return (Collection<Taller>)tallerRepository.findAll();
    }
}
