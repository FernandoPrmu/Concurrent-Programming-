package Hospital_New_Version;

public class HospitalSystem {
    public static void main(String[] args) throws InterruptedException {

            // Shared patient queue between producers and consumers
            PatientQueue queue = new PatientQueue();
            HospitalStats stats = new HospitalStats();
            ShiftManager manager = new ShiftManager(queue, stats);

            stats.startTimer(); // Start system timer

            // Thread that keeps generating new patients
            Thread arrivalThread = new Thread(new PatientArrivalGenerator(queue, stats));
            arrivalThread.start();

            // Start DAY shift
            manager.startShift("DAY");
            Thread.sleep(15000);
            manager.endShift();

            // Start NIGHT shift
            manager.startShift("NIGHT");
            Thread.sleep(15000);
            manager.endShift();

            // Stop patient arrivals
            arrivalThread.interrupt();

            stats.endTimer();
            stats.printSummary();
        }
    }
