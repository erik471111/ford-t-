/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package topdown;

import java.util.ArrayList;

import java.util.List;


/**
 *
 * @author erik4
 */
public class Topdown {
String keresett;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    
       String ujszo="S";
       String megoldas="b+a";
    String ures="";
    String ne="";
       List myList = new ArrayList();
       myList.add("S");
       myList.add("S");
       myList.add("T");
       myList.add("T");
       
       List myList2 = new ArrayList();
       myList2.add("T+S"); 
       myList2.add("T");
       myList2.add("a");
       myList2.add("b");
        String szab1=(String) myList.get(0);
        String szab2=(String) myList.get(1);
        String szab3=(String) myList.get(2);
        String szab4=(String) myList.get(3);
        String szab5=(String) myList2.get(0);
        String szab6=(String) myList2.get(1);
        String szab7=(String) myList2.get(2);
        String szab8=(String) myList2.get(3);
        
        
        System.out.println(ujszo);
       // System.out.println(alma+" ez al,a");
        for (int i = 0; i < myList.size(); i++) {
            if (ujszo.lastIndexOf(szab1)>-1){
                    ujszo = ujszo.replace(szab1, szab5);
                    System.out.println(ujszo);
                  if(ujszo.length()>megoldas.length()-1){
                     
                       ujszo = ujszo.replace(szab1, szab3);
                       System.out.println(ujszo);
                  }
                  
                  for (int j = 0; j < megoldas.length(); j++) {
                 
                      System.out.println(ujszo);
                       ujszo = ujszo.replaceFirst(szab6, szab7);
                     
                        if (ujszo.charAt(j)==megoldas.charAt(j)) {
                        
                           ures=ures+ujszo.charAt(j);
                           
                        }else{ 
                            ujszo = ujszo.replace(szab7, szab8);
                           
                            ures=ures+ne+ujszo.charAt(j);
                          
                        }
                   
                if (ures.length()==megoldas.length() && megoldas.equals(ures) ) {
                    System.out.println(ures);
                    System.out.println("vége");
                    break;
                    
                }
   
        }}}
    }}
        
        
 
       
       
            
           
           
                 
                 
                 
                 
                 
           
     
    
    
