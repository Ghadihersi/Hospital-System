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
public class Doctor  extends Staff{
    private double consultationFees;
    
    
    public Doctor(double consultationFees, String staffid,String specialization,int id,String name,String nationality,char gender,int phone){
        super(id,name,nationality,gender,phone,specialization,staffid);
        this.consultationFees=consultationFees;
    }
    
    public void setConsultationFees(double consultationFees)  {
        this.consultationFees=consultationFees;
    }
    
    public double getConsultationFees(){
        return consultationFees;
    }
    
  

    @Override
    public String toString() {
        return super.toString() + "ConsultationFees: " + getConsultationFees()+"\n" ;
    }
    
    

    
    
}
