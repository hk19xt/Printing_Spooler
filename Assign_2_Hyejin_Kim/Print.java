package Assign_2_Hyejin_Kim;

import BasicIO.*;

/** This class is Print.
  *
  * @author Hyejin Kim
  * @Student #6823116
  * @version 1.0 (2/24/2020)**/

public class Print {
    
    
    public  static final String[] PRIORITIES = {"Student","Staff","Faculty"}; 
    private static final int[] RANK = {1,2,3}; /*Student has the first priority, staff is second, and faculty is third.*/
    
    private String  description;   
    private String  sender;   
    private int     priority;   
    private int     pages;

    public Print (BasicForm form) {
        
        description = form.readString("description");
        sender = form.readString("sender");
        priority = form.readInt("priority");
        pages = form.readInt("pages");
       
    };  // constructor
    
    public String getDescription ( ) {
        
        return description;
        
    };  // getDescription
    
    
    public String getSender ( ) {
        
        return sender;
        
    };  // getSender
    
    
    public int getPriority ( ) {
        
        return priority;
        
    };  // getPriority
    
    
    public int getPages ( ) {
        
        return pages;
        
    };  // getPages
    
    public int getRank(){
      
        return RANK[priority];
    
    } //getRank
    
    
}  // Print