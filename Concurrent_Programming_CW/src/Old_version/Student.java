package Old_version;

import java.util.Random;

public class Student {
    private int Student_Id;
    private String name;
    private Random random;

    public Student(int student_Id, String name) {
        this.Student_Id = student_Id;
        this.name = name;
        this.random = new Random();
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String submitExam() throws InterruptedException {
        int processTime = random.nextInt(100);
        Thread.sleep(processTime);
        int resultTime = random.nextInt(100);
        if(resultTime > 10){
            return "Successfully Submitted";
        }else{
            return "Failure Timeout";
        }
    }

}
