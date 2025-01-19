
package kauhospitalsystem;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;

public class KAUHospitalSystem {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input(1).txt");//object to read from the file input(1).txt
        Scanner input1 = new Scanner(input);//Scanner object to read from file input(1).txt
        if (!input.exists()) {//if statment to make sure the file exist
            System.out.println("File does not exist!");
        }
        File Output = new File("Output.txt");//object pointer to write on the file
        PrintWriter writer = new PrintWriter(Output);
        String command = null;
        int counter1=0;//HRooms array counter 
        int counter2=0;//HMedicine array counter
        int counter3=0;//HPerson array counter
        Room[] HRooms = new Room[input1.nextInt()];
        Medicine[] HMedicine = new Medicine[input1.nextInt()];
        Person[] HPerson = new Person[input1.nextInt()];
       
        writer.println("--------------- Welcome to KAU Hospital System ---------------");
        do {
            command = input1.next();//command will be read from the file
            if (command.equalsIgnoreCase("Add_Room")) {
                HRooms[counter1] = getRoom(input1);
                writer.println("Command Add_Room: Add a new room record in the System");
                writer.println(HRooms[counter1].toString());
                writer.println("----------------------------------------------------------------");
                counter1++;
            } else if (command.equalsIgnoreCase("Add_Medicine")) {
                HMedicine[counter2] = getMedicineRecord(input1);
                writer.println("Command Add_Medicine: Add a new Medicine record in the System");
                writer.println(HMedicine[counter2].toString());
                writer.println("----------------------------------------------------------------");         
                counter2++;
                
            } else if (command.equalsIgnoreCase("Add_Doctor")) {
                HPerson[counter3] = getDoctor(input1);
                writer.println("Command Add_Doctor: Add a new doctor record in the System");
                writer.println(HPerson[counter3].toString());
                writer.println("----------------------------------------------------------------");
                counter3++;
                
            } else if (command.equalsIgnoreCase("Add_Nurse")) {
                HPerson[counter3] = getNurse(input1);
                writer.println("Command Add_Nurse: Add a new nurse record in the System");
                writer.println(HPerson[counter3].toString());
                writer.println("----------------------------------------------------------------");
                counter3++;
                
            } else if (command.equalsIgnoreCase("Add_Patient")) {
                HPerson[counter3] = getPatient(input1);
                writer.print("Command Add_Patient:"+"\nAdd a new Patient record in the System");
                writer.println("\n"+HPerson[counter3].toString());
                writer.println("----------------------------------------------------------------");
                Patient patient=(Patient)HPerson[counter3];
                counter3++;
                
            } else if (command.equalsIgnoreCase("Assign_Doctor_Patient")) {//command that assign each doctor  to it's patient using the ids in the input file
                writer.println("Command Assign_Doctor_Patient:");
                int DoctorID=input1.nextInt();
                int PatientID=input1.nextInt();
                Doctor doctor1=SearchDoctor( HPerson,DoctorID);
                Patient patient1=SearchPatient(HPerson,PatientID);;
                if(doctor1==null){
                    writer.println("Doctor " +DoctorID+" NOT FOUND ");
                    writer.println("----------------------------------------------------------------");
                    continue;
                }
                if(patient1==null){
                    writer.println("Patient "+PatientID+" NOT FOUND");  
                    writer.println("----------------------------------------------------------------");
                    continue; 
                }
                
                patient1.setDoctor(doctor1);//set patient to doctor
                //prints patient and doctor details
                writer.println("Successfully Processed by the System:" + "\nFollowing are the details:");
                writer.println("Patient: "+patient1.getName());
                writer.println("Assigned to Doctor: "+doctor1.getName());
                writer.println("----------------------------------------------------------------");
               
            }
            
              
            else if(command.equalsIgnoreCase("Assign_Room_Patient")){//command that assign each patient to it's room using the id and the room number in the input file
                writer.println("Command Assign_Room_Patient:");
               
                
                int RoomNo=input1.nextInt();//room number 
                int PatientID=input1.nextInt();//patient ID
                Room room1=SearchRoom(HRooms,RoomNo);//to store the index room int the room1 object
                Patient patient2=SearchPatient(HPerson,PatientID);//patient object to store the patient object searched for
                 if(room1==null){//statment make sure that the room is found 
                   writer.println(" Room "+ RoomNo+" NOT FOUND");
                   writer.println("----------------------------------------------------------------");
                   continue;
                }
                 //test if the object is null or filled
                if(patient2==null){
                    writer.println("Patient "+PatientID+" NOT FOUND");
                    writer.println("----------------------------------------------------------------");
                    continue;
                }
                
                
                
                patient2.setRoom(room1);//set patient to the room number
                //print patient and room details 
                writer.println("Successfully Processed by the System:"+"\nFollowing are the details:");
                writer.println("Patient: "+patient2.getName());
                writer.println("Assigned to Room: "+patient2.getRoom());
                
                writer.println("----------------------------------------------------------------");
        
            
            
         }//end of command assign room patient block
            
        else if(command.equalsIgnoreCase("Assign_Medicine_Patient")){
                writer.println("Command Assign_Medicine_Patient");
                int PatientID=input1.nextInt();
                int Totalmedicine=input1.nextInt();
                int MedicinesArray[]=new int[Totalmedicine];
     
                for(int i=0;i<MedicinesArray.length;i++){
                    MedicinesArray[i]=input1.nextInt();   
                }
                 
             Patient patientobj=SearchPatient(HPerson,PatientID);   
             //test if the object is null or filled
            if(patientobj==null){
                writer.println("Patient"+PatientID+"NOT FOUND");
                writer.println("-----------------------------------------------------------------------------");
                  continue;      
            }
            if(Totalmedicine!=patientobj.getTotalMedicine()){
                writer.println("Information mismatch: Patient " + PatientID + "must have " + patientobj.getTotalMedicine() + " medicine not " + Totalmedicine);  
                writer.println("-----------------------------------------------------------------------------");
            }
            //test if the medicine is in the HPerson array
            int Existmedicine=0;
            int notfoundmedicine=0;
            for(int i=0;i<MedicinesArray.length;i++){
                for(int j=0;j<HMedicine.length;j++){
                    if(MedicinesArray[i]==HMedicine[j].getMedicinecode()){
                        Existmedicine++;
                        break;
                    }
                }
                if(Existmedicine!=(i+1)){//makes sure that the existmedicine==MedicineArray.length
                  notfoundmedicine= MedicinesArray[i];
                  break;
                }
            }
            
            if (Existmedicine != MedicinesArray.length) {//prints non found medicines
                    writer.println("Medicines " +notfoundmedicine + " NOT FOUND");
                    writer.println("-----------------------------------------------------------------------------");
                    continue;
                }     
           int index=0;
          if(Totalmedicine==patientobj.getTotalMedicine()){
             writer.println("Successfully Processed by the System:\nFollowing are the details:");
             writer.println("Patient: "+patientobj.getName());
            for(int i=0;i<MedicinesArray.length;i++){ 
                 Medicine medicine=null;
                for(int j=0;j<HMedicine.length;j++){
                    if(MedicinesArray[i]==HMedicine[j].getMedicinecode()){
                        medicine=HMedicine[j];
                      
                         break;  
                    } 
                }
                index=i;
             patientobj.setMedicine(medicine, i);//set patient to medicine 
              writer.println("        Medicine Prescribed: " + patientobj.getMedicine(index).getName());   
            }
              writer.println("-----------------------------------------------------------------------------");
          }
         

    }//end of command assign medicine patient block
                
               
         else if(command.equalsIgnoreCase("Print_Bill")){
             writer.println("Command: Print_Bill");
             writer.println();
             writer.println();
             writer.println();
             writer.println("--------------- Welcome to KAU Hospital System ---------------\n");
             writer.println("-------- Current Date :  "+new Date()+"--------\n");
             writer.println("==================================================================");
             Arrays.sort(HPerson);
             Patient patientobj2=null;
            for(int j=0;j<HPerson.length;j++){
                if(HPerson[j] instanceof Patient){
                    patientobj2=(Patient) HPerson[j];
                   writer.println(patientobj2.PrintBasicinformation());
                   writer.println("Doctor :"+patientobj2.getDoctor().getName()+"\tDoctor Consultation Fees: "+patientobj2.getDoctor().getConsultationFees()+"SR"+"\t");
                   writer.println("Medicines  are:  ");
                   // loop to print patient's medicines
                for(int i=0;i<patientobj2.getTotalMedicine();i++){
                    writer.println("Medicine name:"+patientobj2.getMedicine(i).getName()+"\t\tPrice"+patientobj2.getMedicine(i).getPrice()+"SR");
                  
                }
                
                    writer.println("Room:"+patientobj2.getRoom().getRoomNO()+" Room Charge: "+patientobj2.getRoom().getCharges());
                    writer.println("==== Total Charges :"+patientobj2.calTotalBill()+" SR ====");
                    writer.println("----------------------------------------------------------------");
                    
                }
            }
                
          }//end of command Print_bill block
         else if(command.equalsIgnoreCase("Quit")){
             writer.println("Thank you for using KAU Hospital System, Good Bye!");
         }
            
                 
        } while (!command.equalsIgnoreCase("Quit"));//end block of do while loop
                                                    
        input1.close();
        writer.close();
        writer.flush();

    }// end of main methode

    private static Room getRoom(Scanner input) {//returns room object to the array 
        return new Room(input.nextInt(), input.next(), input.next(), input.nextDouble());
    }

    private static Medicine getMedicineRecord(Scanner input) {//returns Medicine object to the array 
        return new Medicine(input.nextInt(), input.next(), input.nextDouble());
    }

    private static Doctor getDoctor(Scanner input) {//returns Doctor object to the array 
        return new Doctor(input.nextDouble(), input.next(), input.next(), input.nextInt(), input.next(), input.next(), input.next().charAt(0), input.nextInt());
    }

    private static Nurse getNurse(Scanner input) {//returns Nurse object to the array 
        return new Nurse(input.nextInt(), input.next(), input.next(), input.nextInt(), input.next(), input.next(), input.next().charAt(0), input.nextInt());

    }

    private static Patient getPatient(Scanner input) {//returns Patient object to the array 
        return new Patient(input.next(), input.next(), input.nextInt(), input.next(), input.next(), input.next().charAt(0), input.nextInt(), input.nextInt());
    }
    
    
    public static Room SearchRoom(Room[] rooms, int RoomNo){//methode that search for room with the same room number that pass to it
         for(int i=0;i<rooms.length;i++){
                    if(rooms[i].getRoomNO()==RoomNo ){
                      return rooms[i];    
                    }      
                }   
                return null;         
    }
    public static Patient SearchPatient(Person[] person,int patientId){//methode to search for patient  with the same id that passed to the methode
        for(int i=0;i<person.length;i++){
                    if(person[i].getId()==patientId){
                        if(person[i] instanceof Patient){
                            return (Patient) person[i];
                            
                        }
                    }
                }
        return null;
        
    }
    public static Doctor SearchDoctor(Person[] person,int doctorid){//methode to search for doctor  with the same id that passed to the methode
        for(int i=0;i<person.length;i++){
                    if(person[i].getId()==doctorid){
                        if(person[i] instanceof Doctor){
                            return (Doctor) person[i];
                            
                        }
                    }
                }
        return null;        
    }
     
 }//end of class KAUHospitalSystem  block
    


