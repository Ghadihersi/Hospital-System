
package kauhospitalsystem;

/**
 *
 * @author ghadihersi
 */
public class Medicine {
   private int medicinecode;
   private String name;
   private double price;
   
   
   
   
   public Medicine(int medicinecode,String name,double price){
       this.medicinecode=medicinecode;
       this.name=name;
       this.price=price;
   }

    public int getMedicinecode() {
        return medicinecode;
    }

    public void setMedicinecode(int medicinecode) {
        this.medicinecode = medicinecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
   
   
   
  
    
    @Override
    public String toString() {
        return "Medicine Code: "+getMedicinecode()+"\nName:"+getName()+"\nPrice :"+getPrice()+"\n";
    }
   
    
}
