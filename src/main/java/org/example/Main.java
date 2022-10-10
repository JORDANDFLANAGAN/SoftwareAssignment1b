package org.example;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Lecturer p1 = new Lecturer("Pr. Jacobs", 44, "12/09/1978", 12212);
        Lecturer p2 = new Lecturer("Pr. Mike", 34, "11/12/1988", 122121);

        Module mod1 = new Module("CS404", "199998", p1);
        Module mod2 = new Module("CT232", "198878", p2);
        Module mod3 = new Module("AC3333", "198878", p2);

        CourseProgramme course1 = new CourseProgramme("Computer Science", new LocalDate(2022, 11, 22), new LocalDate(2023, 04, 11));
        CourseProgramme course2 = new CourseProgramme("Accountancy", new LocalDate(2021,11,11), new LocalDate(2024, 05, 12));

        Student s1 = new Student("Shane", 22, "11/03/1999", 183338, course1);
        Student s2 = new Student("Declan", 23, "21/09/2000", 21222, course2);
        Student s3 = new Student("Jack", 22, "23/02/1998", 243424, course2);
        Student s4 = new Student("Sally", 19, "04/09/2001", 34232, course1);


        p1.addModule(mod1);
        p2.addModule(mod2);
        p2.addModule(mod3);

        mod1.addStudent(s1);
        mod1.addStudent(s2);
        mod2.addStudent(s3);
        mod2.addStudent(s4);
        mod3.addStudent(s3);
        mod3.addStudent(s4);

        mod1.addCourses(course1);
        mod2.addCourses(course2);
        mod3.addCourses(course2);

        course1.addModule(mod1);
        course2.addModule(mod2);
        course2.addModule(mod3);
        course1.addStudent(s1);
        course1.addStudent(s4);
        course2.addStudent(s2);
        course2.addStudent(s3);

        s1.addModule(mod1);
        s2.addModule(mod2);
        s2.addModule(mod3);
        s3.addModule(mod2);
        s3.addModule(mod3);
        s4.addModule(mod1);

        Main m1 = new Main();
        System.out.println(m1.writeInfo(course1));
        System.out.println(m1.writeInfo(course2));
    }

    public String writeInfo(CourseProgramme course) {
        String output = "--COURSE--\n";
        output += course.getCourseName() + "\n";
        output += "--MODULES--\n";
        for(int i=0; i<course.getModules().size(); i++) {
            output += course.getModules().get(i).getName() + "\n";
        }
        output += "--STUDENTS--\n";
        for(int i=0; i<course.getStudents().size(); i++) {
            output += "[" + (i+1) + "] " + course.getStudents().get(i).getName() + "\n";
            output += "USERNAME: " + course.getStudents().get(i).getUsername() + "\n";
            output += "-----STUDENT REGISTERED MODULES-----\n";
            for(int j=0; j<course.getStudents().get(i).getModules().size(); j++) {
                output += course.getStudents().get(i).getModules().get(j).getName() + "\n";
            }
        }

        return output;
    }
}