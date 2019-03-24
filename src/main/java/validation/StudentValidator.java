package validation;
import domain.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator implements Validator<Student> {
    public final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")) {
            throw new ValidationException("ID invalid! \n");
        }
        if (student.getNume() == null || student.getNume().equals("")) {
            throw new ValidationException("Nume invalid! \n");
        }
        if (student.getGrupa() <= 110 || student.getGrupa() >= 938) {
            throw new ValidationException("Grupa invalida! \n");
        }
        if (student.getProfesor().equals("")) {
            throw new ValidationException("Profesor invalid! \n");
        }
        if (student.getEmail().equals("")) {
            throw new ValidationException("Email invalid! \n");
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(student.getEmail());
        if(!matcher.find())
        {
            throw new ValidationException("Email invalid");
        }
    }
}

