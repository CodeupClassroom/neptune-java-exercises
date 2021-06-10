package grades;

import util.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GradesApplication {

    public static void main(String[] args) {
        Input sc = new Input();
        Student grissom = new Student("Gil Grissom");
        Student caine = new Student("Horatio Caine");
        Student russell = new Student("D.B. Russell");
        Student langston = new Student("Raymond Langston");
        Student brown = new Student("Warrick Brown");

        grissom.addGrade(98);
        grissom.addGrade(86);
        grissom.addGrade(92);
        grissom.addGrade(94);
        grissom.addGrade(99);

        caine.addGrade(84);
        caine.addGrade(82);
        caine.addGrade(90);
        caine.addGrade(76);
        caine.addGrade(81);

        russell.addGrade(64);
        russell.addGrade(81);
        russell.addGrade(68);
        russell.addGrade(72);
        russell.addGrade(78);

        langston.addGrade(92);
        langston.addGrade(100);
        langston.addGrade(98);
        langston.addGrade(96);
        langston.addGrade(100);

        brown.addGrade(88);
        brown.addGrade(88);
        brown.addGrade(91);
        brown.addGrade(96);
        brown.addGrade(88);

        grissom.recordAttendance("2018-06-13", "A");
        grissom.recordAttendance("2018-06-14", "P");
        grissom.recordAttendance("2018-06-15", "P");
        grissom.recordAttendance("2018-06-18", "P");
        grissom.recordAttendance("2018-06-19", "P");
        grissom.recordAttendance("2018-06-20", "P");
        grissom.recordAttendance("2018-06-21", "P");
        grissom.recordAttendance("2018-06-22", "P");
        grissom.recordAttendance("2018-06-25", "P");

        caine.recordAttendance("2018-06-13", "P");
        caine.recordAttendance("2018-06-14", "P");
        caine.recordAttendance("2018-06-15", "A");
        caine.recordAttendance("2018-06-18", "A");
        caine.recordAttendance("2018-06-19", "P");
        caine.recordAttendance("2018-06-20", "P");
        caine.recordAttendance("2018-06-21", "P");
        caine.recordAttendance("2018-06-22", "P");
        caine.recordAttendance("2018-06-25", "A");

        russell.recordAttendance("2018-06-13", "P");
        russell.recordAttendance("2018-06-14", "P");
        russell.recordAttendance("2018-06-15", "P");
        russell.recordAttendance("2018-06-18", "P");
        russell.recordAttendance("2018-06-19", "P");
        russell.recordAttendance("2018-06-20", "P");
        russell.recordAttendance("2018-06-21", "P");
        russell.recordAttendance("2018-06-22", "P");
        russell.recordAttendance("2018-06-25", "P");

        langston.recordAttendance("2018-06-13", "P");
        langston.recordAttendance("2018-06-14", "P");
        langston.recordAttendance("2018-06-15", "P");
        langston.recordAttendance("2018-06-18", "P");
        langston.recordAttendance("2018-06-19", "P");
        langston.recordAttendance("2018-06-20", "P");
        langston.recordAttendance("2018-06-21", "P");
        langston.recordAttendance("2018-06-22", "P");
        langston.recordAttendance("2018-06-25", "P");

        brown.recordAttendance("2018-06-13", "P");
        brown.recordAttendance("2018-06-14", "P");
        brown.recordAttendance("2018-06-15", "P");
        brown.recordAttendance("2018-06-18", "A");
        brown.recordAttendance("2018-06-19", "A");
        brown.recordAttendance("2018-06-20", "A");
        brown.recordAttendance("2018-06-21", "A");
        brown.recordAttendance("2018-06-22", "A");
        brown.recordAttendance("2018-06-25", "P");

        HashMap<String, Student> students = new HashMap<>();
        students.put("gil-grissom", grissom);
        students.put("h-caine", caine);
        students.put("db-russell", russell);
        students.put("lang-ray", langston);
        students.put("warrick-b", brown);

        List<String> keys = new ArrayList<>();
        for (String userName : students.keySet()) {
            keys.add(userName);
        }

        Collections.sort(keys);

        boolean running = true;

        while(running) {
            System.out.println("Hello. Welcome to the grade-o-sphere...");
            System.out.println("Here are your students...");
            System.out.println("===~~~---+++***+++---~~~===");
            String message = "| ";
            for (String userName : keys) {
                message += userName + " | ";
            }
            System.out.println(message);
            System.out.println("Please type username of student you would like to access...");
            String inputName = sc.getString();
            if (students.containsKey(inputName)) {
                System.out.printf("%nName: %s - Github Username: %s", students.get(inputName).getName(), inputName);
                System.out.printf("%nGrade Average: %.2f", students.get(inputName).getGradeAverage());
                students.get(inputName).attendancePercentage();
            } else {
                System.out.println("Student not found...");
            }
            System.out.println("Do you wish to continue accessing grade-o-sphere?");
            boolean answer = sc.yesNo();
            if (answer) {
                System.out.println("Restarting...");
            } else {
                running = false;
                System.out.println("Logging out...");
            }
        }

    }
}
