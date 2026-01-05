package Hospital_Old_Version;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LegacyHospitalSystem {
    public static void main(String[] args) throws InterruptedException {

        Queue<Patient> waitingQueue = new LinkedList<>();

        Consultant paediatrician = new Consultant("Dr A", Speciality.PAEDIATRICIAN);
        Consultant surgeon = new Consultant("Dr B", Speciality.SURGEON);
        Consultant cardiologist = new Consultant("Dr C", Speciality.CARDIOLOGIST);

        Random random = new Random();

        int patientId = 1;

        // Simulate patient arrivals
        for (int i = 0; i < 15; i++) {

            String speciality = Speciality.values()[random.nextInt(3)];

            Patient patient = new Patient(patientId++, speciality);
            waitingQueue.add(patient);

            System.out.println("ARRIVED: " + patient);
            Patient next = waitingQueue.poll();

            if (next != null) {
                if (paediatrician.canTreat(next)) {
                    paediatrician.treatPatient(next);
                } else if (surgeon.canTreat(next)) {
                    surgeon.treatPatient(next);
                } else if (cardiologist.canTreat(next)) {
                    cardiologist.treatPatient(next);
                } else {
                    System.out.println("No consultant available for " + next);
                }
            }
        }

        System.out.println("\nLegacy system finished processing.");
    }
}
