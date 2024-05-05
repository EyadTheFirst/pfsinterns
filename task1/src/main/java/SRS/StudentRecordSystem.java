package SRS;
import Exceptions.*;
import java.io.IOException;
import java.io.*;
import java.rmi.StubNotFoundException;
import java.util.*;

public class StudentRecordSystem {
    //public static Queue<Student> recordSystem=new LinkedList<>();

    public static void Add(String name,String rollNumber,String mathGrade,String englishGrade,String chemistryGrade) throws StudentIsAlreadyRecorded {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";

        try {
            if (name==null||rollNumber==null||mathGrade==null||englishGrade==null||chemistryGrade==null)
                throw new WrongInput();

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt"));

            while (br.ready())
            {
                String nextLine = br.readLine();
                String[] data = nextLine.split(",");

                if (data.length != 5)
                {
                    throw new InvalidCSVFormat(nextLine);
                }

                if (data[0].equals(name))
                    throw new StudentIsAlreadyRecorded();
            }

            br.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(name+","+rollNumber+","+mathGrade+","+englishGrade+","+chemistryGrade);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public static void Display(String name) throws StudentNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt"));
        boolean e=true;
        Student reg=new Student();

        while (br.ready())
        {
            String nextLine = br.readLine();
            String[] data = nextLine.split(",");

            if (data.length != 5)
            {
                throw new InvalidCSVFormat(nextLine);
            }
            if (data[0].equals(name)) {
                e=false;
                reg = new Student(data[0], Integer.parseInt(data[1]),
                        Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                break;
            }
        }
        if (e)
            throw new  StudentNotFoundException();
        else
            reg.tostring();

        br.close();
    }
    public static void DisplayAll() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt"));
        Student reg=new Student();

        while (br.ready())
        {
            String nextLine = br.readLine();
            String[] data = nextLine.split(",");

            if (data.length != 5)
            {
                throw new InvalidCSVFormat(nextLine);
            }
            reg = new Student(data[0], Integer.parseInt(data[1]),
                    Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]));
            reg.tostring();
            System.out.println();
        }

        br.close();
    }
    public static void Delete(String name) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else
                    e=false;
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void UpdateName(String name, String updated) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else {
                    e=false;
                    String[] data = line.split(",");
                    data[0]=updated;
                    content.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]).append("\n");                }
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void UpdateRollNumber(String name, String updated) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else {
                    e=false;
                    String[] data = line.split(",");
                    data[1]=updated;
                    content.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]).append("\n");
                }
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void UpdateMathGrade(String name, String updated) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else {
                    e=false;
                    String[] data = line.split(",");
                    data[2]=updated;
                    content.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]).append("\n");                }
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void UpdateEnglishGrade(String name, String updated) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else {
                    e=false;
                    String[] data = line.split(",");
                    data[3]=updated;
                    content.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]).append("\n");                }
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void UpdateChemistryGrade(String name, String updated) throws StudentNotFoundException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        boolean e=true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if ((!line.contains(name+","))&& (!(line.startsWith(name+",")))) {
                    content.append(line).append("\n");
                }
                else {
                    e=false;
                    String[] data = line.split(",");
                    data[4]=updated;
                    content.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]).append("\n");                }
            }
            reader.close();

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();
            if (e)
                throw new StudentNotFoundException();
        } catch (IOException ex) {
            System.out.println("An error occurred while deleting the Student from the Data Base.");
            ex.printStackTrace();
        }
    }
    public static void ClearAll() throws IOException {
        String filePath = "C:\\Users\\mido_\\OneDrive\\Desktop\\task1\\src\\main\\java\\DataBase.txt";
        StringBuilder content = new StringBuilder();
        //content.append("");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content.toString());
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        ClearAll();
        Add("hazem","1478","87.0","95.14","82.5");
        Add("eyad","1378","82.0","90.14","92.5");
        Add("ezz","1278","67.0","75.14","52.5");
        Add("yassin","1477","0.0","0.0","0.0");
//        Display("ezz");
//        System.out.println("-----------------------------------------------------------------------");
//        DisplayAll();
//        System.out.println("-----------------------------------------------------------------------");
        //Delete("ayad");
//        System.out.println("-----------------------------------------------------------------------");
//       Add("eyad","1378","82.0","90.14","92.5");
//        System.out.println("-----------------------------------------------------------------------");
        //Delete("eyad");
//        System.out.println("-----------------------------------------------------------------------");
        //Display("eyad");
//        System.out.println("-----------------------------------------------------------------------");
        Display("yassin");
        System.out.println("-----------------------------------------------------------------------");
        UpdateName("yassin","Tamer");
        UpdateRollNumber("Tamer","1111");
        UpdateMathGrade("Tamer","100.0");
        UpdateEnglishGrade("Tamer","101.5");
        UpdateChemistryGrade("Tamer","45.2");
        Display("Tamer");
    }
}