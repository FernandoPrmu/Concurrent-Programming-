package Hospital_New_Version;

import java.util.concurrent.atomic.AtomicInteger;

public class HospitalStats {

    // Thread-safe counters for statistics
    private final AtomicInteger totalArrived = new AtomicInteger(0);
    private final AtomicInteger totalTreated = new AtomicInteger(0);

    private final AtomicInteger paediatricianCount = new AtomicInteger(0);
    private final AtomicInteger surgeonCount = new AtomicInteger(0);
    private final AtomicInteger cardiologistCount = new AtomicInteger(0);

    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void endTimer() {
        endTime = System.currentTimeMillis();
    }

    public void patientArrived() {
        totalArrived.incrementAndGet(); // increase by one patient
    }

    public void patientTreated(String speciality) {
        totalTreated.incrementAndGet();

        if (speciality.equals(Speciality.PAEDIATRICIAN)) {
            paediatricianCount.incrementAndGet();
        } else if (speciality.equals(Speciality.SURGEON)) {
            surgeonCount.incrementAndGet();
        } else if (speciality.equals(Speciality.CARDIOLOGIST)) {
            cardiologistCount.incrementAndGet();
        }
    }

    // Print system performance summary
    public void printSummary() {
        System.out.println("\n=============== SYSTEM SUMMARY ===============");
        System.out.println("\nTotal Patients Arrived          : " + totalArrived.get());
        System.out.println("Total Patients Treated          : " + totalTreated.get());
        System.out.println("Total Patients in Waiting Queue : " + (totalArrived.get() - totalTreated.get()));
        System.out.println("Paediatrician Treated           : " + paediatricianCount.get());
        System.out.println("Surgeon Treated                 : " + surgeonCount.get());
        System.out.println("Cardiologist Treated            : " + cardiologistCount.get());
        System.out.println("Total System Time (sec)         : " +
                ((endTime - startTime) / 1000));
        System.out.println("=============================================");
    }
}
