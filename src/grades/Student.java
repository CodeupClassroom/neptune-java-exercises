package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private List<Integer> grades = new ArrayList<>();
    private Map<String,String> attendance = new HashMap<>();

    public Student() { }

    public Student(String name) {
        this.name = name;
    }

    // returns the student's name
    public String getName() {
        return this.name;
    }
    // adds the given grade to the grades property
    public void addGrade(int grade) {
        this.grades.add(grade);
    }
    // returns the average of the students grades
    public double getGradeAverage() {
        int average = 0;
        int length = grades.size();
        for (int grade : grades) {
            average += grade;
        }
        average /= length;
        return average;
    }

    public void recordAttendance(String date, String value) {
        if (value.equalsIgnoreCase("a")) {
            this.attendance.putIfAbsent(date, "A");
        } else if (value.equalsIgnoreCase("p")) {
            this.attendance.putIfAbsent(date, "P");
        } else {
            System.out.println("Student can only be \"A\"bsent or \"P\"resent...");
        }
    }

    public void attendancePercentage() {
        List<String> absences = new ArrayList<>();
        for (String date : attendance.keySet()) {
            if (attendance.get(date).equalsIgnoreCase("A")) {
                absences.add(date);
            }
        }
        double average = (double) (attendance.size() - absences.size()) / attendance.size();
        average *= 100;
        System.out.printf("%nDays absent: %d" +
                "%nAttendance percentage: %.2f %n"
                , absences.size(), average);
    }

}
