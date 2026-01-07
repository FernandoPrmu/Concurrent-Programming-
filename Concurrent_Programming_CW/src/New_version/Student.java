package New_version;

import java.util.Random;

public class Student {
    private int student_ID;
    private String name;
    private Random random;

    public Student(int student_ID, String name) {
        this.student_ID = student_ID;
        this.name = name;
        this.random = new Random();
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String submitExam() throws InterruptedException {
        int processTime = random.nextInt(100);  // Simulate processing delay (0–99 ms)
        Thread.sleep(processTime);
        int resultTime = random.nextInt(100); // Random chance of success or failure
        if(resultTime > 5){
            return student_ID + " " + "Student successfully Submitted";
        }else{
            return student_ID + " "+"Student failure Timeout";
        }
    }
}
