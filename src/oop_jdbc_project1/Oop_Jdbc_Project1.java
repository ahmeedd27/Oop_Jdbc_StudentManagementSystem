
package oop_jdbc_project1;

import DAO.DAOInterfaceImpl;
import Model.Student;
import java.util.Scanner;


public class Oop_Jdbc_Project1 {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        DAOInterfaceImpl dao=new DAOInterfaceImpl();
        System.out.println("*********WELCOME TO OUR STUDENT MANAGEMENT SYSTEM********");
        while(true){
            
                System.out.println("\n1.ADD STUDENT"
                + "\n2.VIEW ALL STUDENT"
                + "\n3.VIEW STUDENT BY PARTICULAR ID"
                + "\n4.UPDATE EMPLOYEE"
                + "\n5.DELETE EMPLOYEE"
                + "\n6.EXIT"
                + "\n-------------------------------");
            System.out.println("SELECT CHOICE ");
            int ch=input.nextInt();
            if(ch==1){
                System.out.println("Add Employee : ");
                System.out.println("Enter FirstName ");
                String fn=input.next();
                System.out.println("Enter LastName ");
                String sn=input.next();
                Student s1=new Student(fn,sn);
                boolean ans=dao.insertStudent(s1);
                if(ans){
                    System.out.println("STUDENT INSERTED SUCCESSFULY..");
                    System.out.println("-------");
                }else{
                    System.out.println("SOMETHING WENT WRONG.");
                }
                
            }
            else if(ch==2){
                dao.viewAll();
            }
             else if(ch==3){
                System.out.println("Enter The Id Of The Student You Want to View : ");
               int x=input.nextInt();
               boolean ans=dao.viewAllById(x);
              
            }
             else if(ch==4){
                System.out.println("Enter The Id Of The Student You Want To Update ");
               int id1=input.nextInt();
               System.out.println("Enter The New FirstName ");
               String nfn=input.next();
              System.out.println("Enter The New LasttName ");
           String nln=input.next();
               Student s=new Student();
              s.setFirstName(nfn);
            s.setLastName(nln);
              boolean ans=dao.updateStudent(id1, s);
                if(ans){
                    System.out.println("UPDATED SUCCESSFULLY");
                System.out.println("--------------------");
                }
                else{
                    System.out.println("SOMETHING WENT WRONG.");
                }
                
                
            }
             else if(ch==5){
                System.out.println("Enter The Id Number Of The Student You Want To Delete ");
                int x=input.nextInt();
                boolean ans=dao.deleteStudent(x);
                if(ans){
                    System.out.println("DELETED SUCCESSFULLY");
                    System.out.println("--------------------");
                }else{
                    System.out.println("SOMETHING WENT WRONG.");
                }
            }
             else if(ch==6){
                System.out.println("Thank You For Using Our System.");
                System.exit(0);
            }
             else{
                 System.out.println("You Entered NOT VALID Number");
             }
        }
    }
    
}
