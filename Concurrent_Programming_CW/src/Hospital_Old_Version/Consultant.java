package Hospital_Old_Version;

public class Consultant {
    private final String name;
    private final String speciality;

    public Consultant(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public boolean canTreat(Patient patient) {
        return patient.getRequiredSpeciality().equals(speciality);
    }

    public void treatPatient(Patient patient) throws InterruptedException {
        System.out.println(name + " treating " + patient);
        Thread.sleep(1000);
        System.out.println(name + " finished " + patient);
    }
}
