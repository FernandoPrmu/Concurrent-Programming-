package Hospital_New_Version;

import java.time.LocalTime;

public class Patient {
    private final int patientId;
    private final String requiredSpeciality;
    private final LocalTime arrivalTime;

    public Patient(int patientId, String requiredSpeciality) {
        this.patientId = patientId;
        this.requiredSpeciality = requiredSpeciality;
        this.arrivalTime = LocalTime.now();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getRequiredSpeciality() {
        return requiredSpeciality;
    }

    @Override
    public String toString() {
        return "Patient-" + patientId + " [" + requiredSpeciality + "]";
    }
}
