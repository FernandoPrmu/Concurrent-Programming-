package New_version;

public class ExamSubmissionSimulator {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStudents = 500;
        int poolSize = Runtime.getRuntime().availableProcessors()*2;
        NewSubmissionSystem system = new NewSubmissionSystem(numberOfStudents,poolSize);
        system.processSubmissions();
    }
}
