package Hospital_New_Version;

public class Speciality {
    public static final String PAEDIATRICIAN = "PAEDIATRICIAN";
    public static final String SURGEON = "SURGEON";
    public static final String CARDIOLOGIST = "CARDIOLOGIST";

    public static String[] values() {
        return new String[] {
                PAEDIATRICIAN,
                SURGEON,
                CARDIOLOGIST
        };
    }
}
