package pe.company.model;

public class InstructorTecnologia {
    private Instructor instructor;
    private Tecnologia tecnologia;

    public InstructorTecnologia() {

    }

    public InstructorTecnologia(Instructor instructor, Tecnologia tecnologia)
    {
        //this(instructortecnologia.getInstructor(), instructortecnologia.getTecnologia());
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

}
