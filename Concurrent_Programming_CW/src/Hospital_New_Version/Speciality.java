package Hospital_New_Version;

public class Speciality {
    // Constants for medical specialities
    public static final String PAEDIATRICIAN = "PAEDIATRICIAN";
    public static final String SURGEON = "SURGEON";
    public static final String CARDIOLOGIST = "CARDIOLOGIST";

    // Returns all specialities (used for random selection)
    public static String[] values() {
        return new String[] {
                PAEDIATRICIAN,
                SURGEON,
                CARDIOLOGIST
        };
    }
}
