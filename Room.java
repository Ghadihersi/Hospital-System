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
public class Room {
    private int roomNO;
    private String floor;
    private String block;
    private double charges;
    
     
    
    
  public Room(int roomNo,String floor,String block,double charges){
      this.roomNO=roomNo;
      this.charges=charges;
      this.floor=floor;
      this.block=block;
   
  }

    public int getRoomNO() {
        return roomNO;
    }

    public void setRoomNO(int roomNO) {
        this.roomNO = roomNO;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }
  
  
   
    @Override
    public String toString() {
        return "Room No: "+getRoomNO()+ "\nLocated in floor: "+getFloor()+"\nBlock :"+getBlock()+"\nCharges :"+getCharges()+"\n";
    }
   
    



    
}
