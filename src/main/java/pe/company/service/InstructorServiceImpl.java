package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.model.Instructor;
import pe.company.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorRepository instructorRepository;
	

	@Override
	public void insert(Instructor instructor) {
		instructorRepository.insert(instructor);
	}
	
	@Override
	public void update(Instructor instructor) {
		instructorRepository.update(instructor);
	}
	
	@Override
	public void delete(int instructorId) {
		instructorRepository.delete(instructorId);
	}
	
	@Override
	public Instructor findById(int instructorId) {
		return instructorRepository.findById(instructorId);
	}
	
	@Override
	public Collection<Instructor> findAll(){
		return instructorRepository.findAll();
	}

}
