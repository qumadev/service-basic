package pe.company.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.company.model.Instructor;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {
	
	public static Collection<Instructor> itemsInstructor = new ArrayList<>();
	
	@Override
	public void insert(Instructor instructor) {
		itemsInstructor.add(instructor);
	}
	
	@Override
	public void update(Instructor instructor) {
		Instructor oldInstructor = findById(instructor.getInstructorID());
		itemsInstructor.remove(oldInstructor);
		
		Instructor newInstructor = new Instructor(instructor);
		itemsInstructor.add(newInstructor);
	}
	
	@Override
	public void delete(int instructorId) {
		Instructor oldInstructor = findById(instructorId);
		itemsInstructor.remove(oldInstructor);
		
	}
	
	@Override
	public Instructor findById(int instructorId) {
		Optional<Instructor> instructor = itemsInstructor.stream().filter(p -> p.getInstructorID() == instructorId).findFirst();
		
		return instructor.orElse(null);
	}
	
	@Override
	public Collection<Instructor> findAll(){
		return itemsInstructor;
	}

}
