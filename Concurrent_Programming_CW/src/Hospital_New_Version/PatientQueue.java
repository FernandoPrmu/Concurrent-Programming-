package Hospital_New_Version;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PatientQueue {
    private final BlockingQueue<Patient> queue = new LinkedBlockingQueue<>();

    // Add a patient to the queue (blocks if queue is full)
    public void addPatient(Patient patient) throws InterruptedException {
        queue.put(patient);
        System.out.println("ARRIVED: " + patient);
    }

    // Take a patient from the queue (blocks if queue is empty)
    public Patient takePatient() throws InterruptedException {
        return queue.take();
    }

    // Put patient back in queue if consultant can't treat them
    public void requeuePatient(Patient patient) throws InterruptedException {
        queue.put(patient);
    }
}
