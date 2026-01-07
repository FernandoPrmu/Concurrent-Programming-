package Hospital_New_Version;

import java.util.Random;

public class PatientArrivalGenerator implements Runnable {

    // Shared queue to add new patients
    private final PatientQueue patientQueue;
    private final HospitalStats stats;
    // Generates unique patient IDs
    private int patientCounter = 1;

    public PatientArrivalGenerator(PatientQueue patientQueue, HospitalStats stats) {
        this.patientQueue = patientQueue;
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Pick a random speciality
                String[] specialities = Speciality.values();
                String speciality = specialities[(int)(Math.random() * specialities.length)];

                // Create new patient
                Patient patient = new Patient(patientCounter++, speciality);
                // Add patient to queue
                patientQueue.addPatient(patient);
                // Update statistics
                stats.patientArrived();

                // Wait before generating next patient
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

