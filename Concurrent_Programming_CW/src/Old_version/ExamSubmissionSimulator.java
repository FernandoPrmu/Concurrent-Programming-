package Old_version;

public class ExamSubmissionSimulator {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStudents = 50;
        OldSubmissionSystem system = new OldSubmissionSystem(numberOfStudents);
        system.processSubmissions();
    }
}