package Hospital_New_Version;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShiftManager {

    private final PatientQueue patientQueue;
    private final HospitalStats stats;
    private ExecutorService pool;
    private List<Consultant> consultants = new ArrayList<>();

    public ShiftManager(PatientQueue patientQueue, HospitalStats stats) {
        this.patientQueue = patientQueue;
        this.stats = stats;
    }

    public void startShift(String name) {
        System.out.println("\n--- " + name + " SHIFT STARTED ---");

        // Thread pool that runs consultants
        pool = Executors.newFixedThreadPool(3);
        consultants.clear();

        // Assign consultants depending on shift
        if ("DAY".equals(name)) {
            consultants.add(new Consultant("Dr A", Speciality.PAEDIATRICIAN, patientQueue, stats));
            consultants.add(new Consultant("Dr B", Speciality.SURGEON, patientQueue, stats));
            consultants.add(new Consultant("Dr C", Speciality.CARDIOLOGIST, patientQueue, stats));
        } else if ("NIGHT".equals(name)) {
            consultants.add(new Consultant("Dr D", Speciality.PAEDIATRICIAN, patientQueue, stats));
            consultants.add(new Consultant("Dr E", Speciality.SURGEON, patientQueue, stats));
            consultants.add(new Consultant("Dr F", Speciality.CARDIOLOGIST, patientQueue, stats));
        }

        for (Consultant c : consultants) {
            pool.execute(c);
        }
    }

    public void endShift() {
        for (Consultant c : consultants) {
            c.stopConsultant();
        }
        pool.shutdownNow(); // force stop
    }
}

