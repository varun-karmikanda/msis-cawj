package college;

import java.sql.Date;

public class College {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        ExaminationDAO examinationDAO = new ExaminationDAO();
        ResultDAO resultDAO = new ResultDAO();

//        studentDAO.addStudent(3, "Jake", "ME BDA", 1, "jake.paul@gmail.com");
//        studentDAO.updateStudent(3, "John", "ME BDA", 1, "john.pork@gmail.com");

//        subjectDAO.addSubject(3, "DSA", 10, 1);
//        subjectDAO.updateSubject(3, "DSA", 10, 1);

//        examinationDAO.addExamination(3, 1, Date.valueOf("2026-11-06"), 100);
//        examinationDAO.updateExamination(3, 1, Date.valueOf("2026-11-29"), 100);

//        resultDAO.addResult(1, 3, 100, "A");
//        resultDAO.addResult(2, 3, 100, "A");
//        resultDAO.addResult(2, 1, 100, "A");
//        resultDAO.updateResult(1, 3, 100, "S");

//        resultDAO.subjectWiseAvg();
        resultDAO.highScoringStudent();


    }
}
