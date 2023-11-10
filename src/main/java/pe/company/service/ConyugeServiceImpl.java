package pe.company.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Conyuge;
import pe.company.repository.ConyugeRepository;

import java.util.Collection;
@Service
public class ConyugeServiceImpl implements ConyugeService{

    @Autowired
    private ConyugeRepository conyugeRepository;

    @Override
    @Transactional
    public void insert(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    @Transactional
    public void update(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    @Transactional
    public void delete(int conyugeId) {
        conyugeRepository.deleteById(conyugeId);
    }

    @Override
    @Transactional(readOnly = true)
    public Conyuge findById(int conyugeId) {
        return conyugeRepository.findById(conyugeId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Conyuge> findAll(){
        return (Collection<Conyuge>)conyugeRepository.findAll();
    }
}
