package Hospital_New_Version;

import java.util.concurrent.atomic.AtomicBoolean;

public class Consultant implements Runnable {

    private final String name;
    private final String speciality;
    private final PatientQueue patientQueue;
    private final HospitalStats stats;
    private volatile boolean running = true;

    public Consultant(String name, String speciality,
                      PatientQueue patientQueue, HospitalStats stats) {
        this.name = name;
        this.speciality = speciality;
        this.patientQueue = patientQueue;
        this.stats = stats;
    }

    public void stopConsultant() {
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                Patient patient = patientQueue.takePatient();

                if (patient.getRequiredSpeciality().equals(speciality)) {
                    System.out.println(name + " treating " + patient);
                    Thread.sleep(1000);
                    stats.patientTreated(speciality); // 👈 count treated
                    System.out.println(name + " finished " + patient);
                } else {
                    patientQueue.requeuePatient(patient);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
