
package kauhospitalsystem;

/**
 *
 * @author ghadihersi
 */
public class Person implements Comparable<Person>  {
   private int id;
   private String name;
   private String nationality;
   private char gender;
   private int phone;

   
   
   public Person(int id,String name,String nationality,char gender,int phone){
       this.gender=gender;
       this.nationality=nationality;
       this.name=name;
       this.phone=phone;
       this.id=id;
       
       
   }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    @Override
    public int compareTo(Person person){
          if (id > person.getId())
            return 1;
        else if (id < person.getId())
            return -1;
        else
            return 0;
        
    }
    

    @Override
    public String toString() {
        return "ID: " + getId() + "\nName: " + getName() + "\nNationality: " + getNationality() + "\nGender: " + getGender() + "\nPhone: " + getPhone();
    }
    
    
    
  
 }
   
   
   
   
           
    

