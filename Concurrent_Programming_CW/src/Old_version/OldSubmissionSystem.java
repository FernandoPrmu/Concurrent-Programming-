package Old_version;

public class OldSubmissionSystem {
    private int numberOfStudents;
    private SubmissionStats stats;

    public OldSubmissionSystem(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        this.stats = new SubmissionStats();
    }

    public void processSubmissions () throws InterruptedException {
        stats.setStartTime();

        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(i + 1, "scec");
            String result = student.submitExam();

            if (result.contains("Success")) {
                stats.recordSuccess();
            } else {
                stats.recordFailure();
            }
        }

        stats.setEndTime();
        stats.display();
    }
}
