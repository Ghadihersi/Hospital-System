
package kauhospitalsystem;

/**
 *
 * @author ghadihersi
 */
public class Nurse extends Staff {

    private int experiance;

    public Nurse(int experiance, String staffid, String specialization, int id, String name, String nationality, char gender, int phone) {
        super(id, name, nationality, gender, phone, specialization, staffid);
        this.experiance = experiance;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    @Override
    public String toString() {
        return super.toString()+"\nExperience Year:" + getExperiance()+"\n" ;
    }
    

}
