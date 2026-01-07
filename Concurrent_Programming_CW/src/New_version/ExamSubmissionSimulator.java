package New_version;

public class ExamSubmissionSimulator {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStudents = 100000;  // Total number of students attempting to submit the exam
        int poolSize = Runtime.getRuntime().availableProcessors()*2; // Thread pool size based on available CPU cores (optimized for performance)
        NewSubmissionSystem system = new NewSubmissionSystem(numberOfStudents,poolSize); // Create the submission system
        system.processSubmissions(); // Start processing all student submissions
    }
}
