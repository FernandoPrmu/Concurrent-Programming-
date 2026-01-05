package Hospital_Old_Version;

public class Patient {
    private final int id;
    private final String requiredSpeciality;

    public Patient(int id, String requiredSpeciality) {
        this.id = id;
        this.requiredSpeciality = requiredSpeciality;
    }

    public int getId() {
        return id;
    }

    public String getRequiredSpeciality() {
        return requiredSpeciality;
    }

    @Override
    public String toString() {
        return "Patient-" + id + " [" + requiredSpeciality + "]";
    }
}
