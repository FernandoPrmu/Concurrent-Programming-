import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SubmissionStats {
    private AtomicInteger successful = new AtomicInteger(0);
    private AtomicInteger failed = new AtomicInteger(0);
    private AtomicLong startTime = new AtomicLong(0);
    private AtomicLong endTime = new AtomicLong(0);
    private int total;


    public void recordSuccess(){
        successful.incrementAndGet();
    }

    public void recordFailure(){
        failed.incrementAndGet();
    }

    public void setStartTime() {
        startTime.set(System.currentTimeMillis());
    }

    public void setEndTime() {
        endTime.set(System.currentTimeMillis());
    }

    public long totalTime(){
        return endTime.get() - startTime.get();
    }

    public int totalSubmission(){
        total = successful.get() + failed.get();
        return total;
    }

    public double successPercentage(){
        return (((double) successful.get() / total) * 100);
    }

    public int successSubmission(){
        return successful.get();
    }

    public int failSubmission(){
        return failed.get();
    }

    public void display(){
        System.out.println("Total Submission : " + totalSubmission());
        System.out.println("Successful Submissions : " + successSubmission());
        System.out.println("Failed Submissions : " + failSubmission());
        System.out.println("Total Time : " + totalTime());
        System.out.println("Percentage of Successful Submissions : " + successPercentage());
    }
}
