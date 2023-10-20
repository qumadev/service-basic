package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Instructor;
import pe.company.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository instructorRepository;
	

	@Override
	@Transactional
	public void insert(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	
	@Override
	@Transactional
	public void update(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	
	@Override
	@Transactional
	public void delete(int instructorId) {
		instructorRepository.deleteById(instructorId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Instructor findById(int instructorId) {
		return instructorRepository.findById(instructorId).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Instructor> findAll(){
		return (Collection<Instructor>)instructorRepository.findAll();
	}

}
