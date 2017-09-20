package BackToSchool;

import java.io.FileNotFoundException;

/**
 * Created by admin on 8/29/2017.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Person person1 = new Person("Iullia Kolesnichenko", 24, "F");
        Student student1 = new Student("Frans Vermut", 20, "M", "234", 4.0);
        Teacher teacher1 = new Teacher("Emma Smith", 38, "F", "Chemistry", 30000);
        CollegeStudent colstudent1 = new CollegeStudent("Greg Terner", 17, "M", "578", 3.9, 2, "English");

        Person [] people = {person1, student1, teacher1, colstudent1};
        for (Person i : people)
            System.out.println (i.toString());
        ReadFile readFile = new ReadFile();
        readFile.parseFile("a.txt");
        System.out.println(new CollegeStudent(readFile.getName(),readFile.getAge(),readFile.getGender(),readFile.getIdNumber(),readFile.getGpa(),readFile.getYear(),readFile.getMajor()));
    }











    }







