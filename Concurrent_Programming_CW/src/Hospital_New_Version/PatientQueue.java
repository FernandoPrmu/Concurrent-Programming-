package Hospital_New_Version;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PatientQueue {
    private final BlockingQueue<Patient> queue = new LinkedBlockingQueue<>();

    public void addPatient(Patient patient) throws InterruptedException {
        queue.put(patient);
        System.out.println("ARRIVED: " + patient);
    }

    public Patient takePatient() throws InterruptedException {
        return queue.take();
    }

    public void requeuePatient(Patient patient) throws InterruptedException {
        queue.put(patient);
    }
}
