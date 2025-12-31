package New_version;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSubmissionSystem {
    private int numberOfStudents;
    private int poolSize;
    private SubmissionStats stats;
    private ExecutorService executor;

    public NewSubmissionSystem(int numberOfStudents, int poolSize) {
        this.numberOfStudents = numberOfStudents;
        this.poolSize = poolSize;
        this.stats = new SubmissionStats();
    }

    public void processSubmissions(){
        stats.setStartTime();

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        CountDownLatch latch = new CountDownLatch(numberOfStudents);
        for (int i = 0; i < numberOfStudents; i++) {
            final int student_ID = i;
            executor.submit(() -> {
                try {
                    Student student = new Student(student_ID,"csss");
                    String result = student.submitExam();
                    if (result.equals("Successfully Submitted")) {
                        stats.recordSuccess();
                    } else {
                        stats.recordFailure();
                    }
                    //System.out.println(result);
                } catch (Exception e) {
                    stats.recordFailure();
                    System.err.println("Error for Student " + student_ID + ": " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("System process was interrupted.");
        }
        executor.shutdown();
        stats.setEndTime();
        stats.display();
    }
}
