
package kauhospitalsystem;


public class Patient  extends Person{
    private String illness;
    private String BloodGroup;
    private Doctor doctor;
    private Medicine[] medicine;
    private Room room;
    
    public Patient(String illness,String BloodGroup,int id,String name,String nationality,char gender,int phone,int toMedicine ){
     super(id,name,nationality,gender,phone);
     this.BloodGroup=BloodGroup;
     this.illness=illness;
     this.medicine= new Medicine[toMedicine];  
    }
    
     public void setMedicine(Medicine medicine, int index) {//
       this.medicine[index] = medicine;
    }
    
    public int getTotalMedicine() {//done
        return medicine.length;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.BloodGroup = bloodGroup;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine(int index) {//
        return medicine[index];
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public double calTotalBill(){//computes the total charge
        double total=0;
        double Fees=doctor.getConsultationFees();
        double RoomCharges=room.getCharges();
        for(int i=0;i<medicine.length;i++){
            total+=medicine[i].getPrice();
        }
        total+=Fees;
        total+=RoomCharges;
       
        return total;    
    }
    
    public String PrintBasicinformation(){
        return "Patient Detail:\n "+"ID:"+getId()+" Name: "+ getName();
    }
    
  
  
  
   public String toString(){
       return super.toString()+"\n-------------------------------------------------------------------------------------------"+"\nIllness:"+getIllness()+"   Blood Group:"+getBloodGroup()
               +"\n-------------------------------------------------------------------------------------------"
               +"\n"
               ;
   }

    
    
    
}
