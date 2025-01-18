/**
 * Name:Ghadi Hersi
 * ID;2105350
 * Section:GAR
 *Course name:CPCS203
 *Assignment;2
 **/
package kauhospitalsystem;

/**
 *
 * @author ghadihersi
 */
public abstract class Staff extends Person {
    private String specialization;
    private String staffid;
    
    
   
   public Staff(int id,String name,String nationality,char gender,int phone,String specialization,String staffid){
      super(id,name,nationality,gender,phone);
      this.specialization=specialization;
      this.staffid=staffid;
   }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nSpecialization: " + getSpecialization() + "\nStaff ID: " + getStaffid();
    }
   
    
}
