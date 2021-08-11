package Assign_2_Hyejin_Kim;

import BasicIO.*;
import static BasicIO.Formats.*;

/** This class is Main class (Print Spooler class).
  *
  * @author Hyejin Kim
  * @Student #6823116
  * @version 1.0 (2/24/2020)**/


public class PrintSpooler {
    
  private Node           wait; //When a user pressed Add Job button.
  private Node           printed; //When a user pressed Print Next button.
  private ASCIIDisplayer display; //When a user pressed Check button, it shows the result list.
  private BasicForm      form; //Interaction with a user.
  
  public PrintSpooler(){
  
    int button;
    
    display = new ASCIIDisplayer();
    form = new BasicForm("Add Job","Print Next","Check","Quit");
    wait = null;
    printed = null;
    setupForm();
    
    for ( ; ; ) {
      /*Clear the forms except for the status text field.*/
      form.clear("description"); 
      form.clear("sender"); 
      form.clear("pages");
      form.clear("priority");
      
      button = form.accept();
      
      if(button == 3) break;    // Quit
      switch(button){
        case 0:{                // Add Job
          doAdd(); 
          break;
         }
        case 1:{                // Print Next
          doPrint();
          break;
        }
        case 2:{                // List
          doCheck();
          break;
        }
      };
    };
    form.close();
    display.close();
  };    
    
  private void doAdd(){
   
    String sender;
    String description;
    int pages;
    int priority;
    Print aPrint;

    
    sender = form.readString("sender");
    description = form.readString("description");
    pages = form.readInt("pages");
    priority = form.readInt("priority");
    
    aPrint = new Print(form);
    
    if(aPrint ==null){ //When the user didn't put any information in the form.
      form.writeString("status","Nothing was added");}
    
    else{
      addWait(aPrint);
      int total = 0;
      Node p = wait;
      
      while(p!=null){ //Total pages added in the waiting list so far.
        total = p.item.getPages()+total;
        p=p.next;
      } 
      form.writeString("status",sender+" was added ("+total+" pages in total)");}
  }  //doAdd
  
  
  private void addWait(Print aPrint){
     
       Node p;
       Node q;
       Node temp;
       
       q = null;
       p = wait;
       
       /*Student has the first priority,
        *staff has the second,and
        *the faculty has the third.*/
       
        while ( p != null && aPrint.getRank()>=p.item.getRank()) { 
          q=p;
          p=p.next;
      
          }
        if ( q == null ) {
            wait = new Node(aPrint,p);
        }
        else {
            q.next = new Node(aPrint,p);
        };
  }  //addWait
  
      
  private void doPrint(){
   
    String sender;
    String description;
    int pages;
    int priority;
    Print aPrint;
    
    aPrint = removeWait();
    int sum = 0;
    
    if(aPrint == null){ //when every document is printed.
      form.writeString("status","There is nothing to print");
    }
    else{
       addCompleted(aPrint);
       int total = 0;
       Node p = printed;
       
       while(p!=null){ //Total pages printed so far.
         total = p.item.getPages()+total;
         p=p.next;
      } 
       form.writeString("status",total+" document(s) printed in total");
    }
    }  //doPrint
  
  
  private void addCompleted(Print aPrint){
    
       Node p;
       Node q;
       Node temp;
       
       q = null;
       p = printed;
       
        while ( p != null && aPrint.getRank()>=p.item.getRank()) {
          q=p;
          p=p.next;
          }
        
        if ( q == null ) {
            printed = new Node(aPrint,p);
        }
        else {
            q.next = new Node(aPrint,p);
        };
  }  //addCompleted
  
  
  private Print removeWait(){
    
        Print result;  
        Node  p;
        Node  q;   
        
        q = null;
        p = wait;

        if ( p == null ) {
            result = null;
        }
        else {
          result=p.item;
          if(q==null){
            wait=p.next;
          }
          else{
          q.next=p.next;
          }
           }
        return result;
  }  //removeWait
    

  
  private void doCheck(){
   
   listWait();
   
  }  //doCheck
  
  private void listWait(){
  
    Node p,q;
    
    p = printed;
    q = wait;
  
    while(p!=null){
      display.writeString("{"+p.item.getSender()+" prints "+ p.item.getDescription() + ":"+p.item.getPages()+" pages}");
      display.newLine();
      p = p.next;
    }
    
    int total;
    total = 0;
    
    while(q!=null){ //Total pages pending.
    total = q.item.getPages()+total;
    q=q.next;
    } 
    form.writeString("status",total+" Pages Pending");
  
    }  //listWait
  
  
    private void addPrinted(Print aPrint){
  
    printed = new Node(aPrint,printed);
 
    }  //addPrinted
  
    private void setupForm(){
    
    form.setTitle("BasicForm");
    form.addTextField("description","Description: ",20,10,10);
    form.addRadioButtons("priority","Priority",true,250,10,Print.PRIORITIES);
    form.addTextField("sender","Sender: ",10,10,40);
    form.addTextField("pages","# Pages: ",5,10,70);
    form.addTextField("status","Status: ",40,10,105);
    form.setEditable("status",false);

    }  //setupForm
    
    public static void main ( String[] args ) { PrintSpooler r = new PrintSpooler(); };
    
    
}  // PrintSpooler