package BackToSchool;

import java.io.*;

/**
 * Created by admin on 9/2/2017.
 */
public class ReadFile {

    private String name;
    private int age;
    private String gender;
    private String idNumber;
    private double gpa;
    private int year;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    private String major;
    private String data;


    private void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        File file = new File("a.txt");

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    public void parseFile(String fileName) {

        try {
            data = read(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] fields = data.split(",");

        for (String s : fields) {

            String[] args = s.split(":");
            System.out.println(args[0]);
            System.out.println(args[1]);

            switch (args[0]) {
                case "name":

                    this.name = args[1];
                    break;

                case "age":

                    this.age = Integer.parseInt(args[1]);
                    break;

                case "gender": {

                    this.gender = args[1];
                    break;
                }
                case "idNumber": {

                    this.idNumber = args[1];
                }
                case "major": {
                    ;
                    this.major = args[1];
                    break;
                }
                case "gpa":

                {
                    this.gpa = Double.parseDouble(args[1]);
                    break;
                }
                case "year": {

                    this.year = Integer.parseInt(args[1]);
                    break;
                }
                default:
                    System.out.printf("ERROR");


            }


        }
    }
}
