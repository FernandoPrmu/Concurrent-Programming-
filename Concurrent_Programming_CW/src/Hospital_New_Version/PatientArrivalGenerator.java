package Hospital_New_Version;

import java.util.Random;

public class PatientArrivalGenerator implements Runnable {

    private final PatientQueue patientQueue;
    private final HospitalStats stats;
    private int patientCounter = 1;

    public PatientArrivalGenerator(PatientQueue patientQueue, HospitalStats stats) {
        this.patientQueue = patientQueue;
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String[] specialities = Speciality.values();
                String speciality = specialities[(int)(Math.random() * specialities.length)];

                Patient patient = new Patient(patientCounter++, speciality);
                patientQueue.addPatient(patient);
                stats.patientArrived();   // 👈 count arrival

                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

