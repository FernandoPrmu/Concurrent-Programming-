package Old_version;

public class ExamSubmissionSimulator {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStudents = 5000;
        OldSubmissionSystem system = new OldSubmissionSystem(numberOfStudents);
        system.processSubmissions();
    }
}