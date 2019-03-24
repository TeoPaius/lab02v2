package domain;

import java.util.Objects;

public class Student implements HasID<String> {
    private String idStudent;
    private String nume;
    private int grupa;
    private String profesor;
    private String email;

    public Student(String idStudent, String nume, int grupa, String profesor, String email) {
        this.idStudent = idStudent;
        this.nume = nume;
        this.grupa = grupa;
        this.profesor = profesor;
        this.email = email;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getID() { return idStudent; }

    @Override
    public void setID(String idStudent) { this.idStudent = idStudent; }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", nume='" + nume + '\'' + ", grupa=" + grupa + '\''
                + ", email=" + email + '\'' + ", profesor=" + profesor + '\'' +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(idStudent, student.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent);
    }
}

