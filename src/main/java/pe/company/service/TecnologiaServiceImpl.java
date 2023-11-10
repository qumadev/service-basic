package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Tecnologia;
import pe.company.repository.TecnologiaRepository;

import java.util.Collection;

@Service
public class TecnologiaServiceImpl implements TecnologiaService{
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    @Override
    @Transactional
    public void insert(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);
    }

    @Override
    @Transactional
    public void update(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);
    }

    @Override
    @Transactional
    public void delete(int tecnologiaId) {
        tecnologiaRepository.deleteById(tecnologiaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Tecnologia findById(int tecnologiaId) {
        return tecnologiaRepository.findById(tecnologiaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Tecnologia> findAll(){
        return (Collection<Tecnologia>)tecnologiaRepository.findAll();
    }
}
