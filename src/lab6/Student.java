package lab6;

import java.io.*;

public class Student {
    private File student_file_path = new File("src/lab6/student.txt");
    private File temp_student_file_path = new File(student_file_path.getAbsolutePath() + ".temp");

    public void insertStudentRecord(String[] studentDetails){
        String regNo = studentDetails[0];
        String name = studentDetails[1];
        String location = studentDetails[2];

        String record = regNo + "," + name + "," + location;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(student_file_path, true))){
            bw.write(record);
            bw.newLine();
            bw.flush();
            System.out.println("Record inserted successfully: " + record);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }

    public void deleteStudentRecord(String name){
        boolean found = false;
        try(
                BufferedReader br = new BufferedReader(new FileReader(student_file_path));
                BufferedWriter bw = new BufferedWriter(new FileWriter(temp_student_file_path))
        ) {
            String record = br.readLine();
            while (record != null) {
                String[] studentRecord = record.split(",");
                if (name.equalsIgnoreCase(studentRecord[1])) {
                    found = true;
                } else {
                    bw.write(record);
                    bw.newLine();
                    bw.flush();
                }
                record = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(found) {
            if(student_file_path.delete() && temp_student_file_path.renameTo(student_file_path)) {
                System.out.println("Record with name " + name + " deleted!");
            } else {
                System.out.println("Could not replace the student file.");
            }
        } else {
            temp_student_file_path.delete();
            System.out.println("Record not found: " + name);
        }
    }

    public void displayAllStudentRecord(){
        try(BufferedReader br = new BufferedReader(new FileReader(student_file_path))){
            String record = br.readLine();
            while(record != null){
                String[] studentRecord = record.split(",");
                System.out.printf("| %-4s | %-10s | %-12s |\n", studentRecord[0], studentRecord[1], studentRecord[2]);

                record = br.readLine();
            }

            System.out.println();
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }

    public void displayAllStudentName(){
        try(BufferedReader br = new BufferedReader(new FileReader(student_file_path))){
            String record = br.readLine();
            while (record != null){
                String[] studentRecord = record.split(",");
                System.out.printf("| %-10s |\n", studentRecord[1]);

                record = br.readLine();
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
