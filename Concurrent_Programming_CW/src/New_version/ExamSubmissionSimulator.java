package New_version;

public class ExamSubmissionSimulator {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStudents = 5000;
        int poolSize = Runtime.getRuntime().availableProcessors();
        NewSubmissionSystem system = new NewSubmissionSystem(numberOfStudents,poolSize);
        system.processSubmissions();
    }
}
