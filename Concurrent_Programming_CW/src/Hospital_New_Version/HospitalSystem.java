package Hospital_New_Version;

public class HospitalSystem {
    public static void main(String[] args) throws InterruptedException {

            PatientQueue queue = new PatientQueue();
            HospitalStats stats = new HospitalStats();
            ShiftManager manager = new ShiftManager(queue, stats);

            stats.startTimer(); // ⏱ start time

            Thread arrivalThread =
                    new Thread(new PatientArrivalGenerator(queue, stats));
            arrivalThread.start();

            manager.startShift("DAY");
            Thread.sleep(15000);
            manager.endShift();

            manager.startShift("NIGHT");
            Thread.sleep(15000);
            manager.endShift();

            arrivalThread.interrupt();

            stats.endTimer();     // ⏱ end time
            stats.printSummary(); // ✅ FINAL SUMMARY
        }
    }
