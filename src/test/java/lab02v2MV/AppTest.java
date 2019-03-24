package lab02v2MV;

import static org.junit.Assert.assertTrue;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    Validator<Student> studentValidator;
    Validator<Tema> temaValidator;
    Validator<Nota> notaValidator;

    StudentXMLRepository fileRepository1;
    TemaXMLRepository fileRepository2;
    NotaXMLRepository fileRepository3;

    Service service;

    @Before
    public void setUp()
    {
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();
        notaValidator = new NotaValidator();

        fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void addStudentTest() {
        service.saveStudent("100","test",935);
        boolean found = false;
        for (Student s:
             service.findAllStudents()) {
            if(s.getID().equals("100"))
            {
                found = true;
            }
        }
        assertTrue(found);
    }


//    public void addStudentTest_validEmail() {
//        service.saveStudent("100","test",935);
//        boolean found = false;
//        for (Student s:
//                service.findAllStudents()) {
//            if(s.getID().equals("100"))
//            {
//                found = true;
//            }
//        }
//        assertTrue(found);
//    }



}
