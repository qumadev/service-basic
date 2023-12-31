package pe.company.service;

import java.util.Collection;
import pe.company.model.Instructor;

public interface InstructorService {

	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(int instructorId);
	public abstract Instructor findById(int instructorId);
	public abstract Collection<Instructor> findAll();
	
}
