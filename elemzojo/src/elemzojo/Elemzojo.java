/*

 */
package elemzojo;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;



/**
 *
 * @author erik4
 */
public class Elemzojo {
    
    int index;
String bemenet;

    public static void main(String[] args) {
        Elemzojo t = new Elemzojo();
        t.index=-1;
        t.bemenet = "222a(dsp{5}*:=<>p$"; //$kell a végére
        System.out.println(t.bemenet);
        for (int i = 0; i < t.bemenet.length(); i++){
            t.felt1();
     }//for vége
    }//main vége
    
    
   void felt1(){
        
        if(index == bemenet.length()-1)
            return;
        index++;
        System.out.println("kezdőállapot");
        if(isLetter(bemenet.charAt(index))) { felt2(); }
        else if(isDigit(bemenet.charAt(index))) {
            felt4();
        } else if(bemenet.charAt(index) == '{') {
            felt6();
        } else if(bemenet.charAt(index) == '(') {
            felt8();
        } else if(bemenet.charAt(index) == ':') {
            felt12();
        } else if(bemenet.charAt(index) == '<') {
            felt14();
        } else if(bemenet.charAt(index) == '>') {
            felt17();
        } else if(bemenet.charAt(index) == ' ') {
            felt1();
        } else if(bemenet.charAt(index) == '$') { felt21(); }
        else { felt19(); }}

    
        void felt2(){
    
        System.out.println("azonosítóban");
        index++;
        if(isLetter(bemenet.charAt(index))) { felt2(); }
        else if(isDigit(bemenet.charAt(index))) { felt2(); }
        else { felt3(); }}
    

       void felt3(){
    
        System.out.println("azonosító vége");
        index--;
        felt1();}
    

        void felt4(){
    
        System.out.println("számban");
        index++;
        if(isDigit(bemenet.charAt(index))) { felt4(); }
        else { felt5(); }}
    

        void felt5(){
    
        System.out.println("szám vége");
        index--;
        felt1();}
    
        
        void felt6(){
    
        System.out.println("{} komm.-ban");
        index++;
        switch (bemenet.charAt(index)) {
            case '}' -> felt7();
            case '$' -> felt19();
            default -> felt6();}}
        
    

    void felt7(){
    
        System.out.println("{} komm. vég");
        felt1();}
    

    void felt8(){
    
        System.out.println("(-talált");
        index++;
        switch (bemenet.charAt(index)) {
            case '*' -> felt9();
            case '$' -> felt19();
            default -> felt20();}}
       

    void felt9(){
    
        System.out.println("(**) komm.ban");
        index++;
        switch (bemenet.charAt(index)) {
            case '*' -> felt10();
            case '$' -> felt19();
            default -> felt9();}}
    

    void felt10(){
    
        System.out.println("* (**)-ban");
        index++;
        switch (bemenet.charAt(index)) {
            case '*' -> felt10();
            case ')' -> felt11();
            case '$' -> felt19();
            default -> felt9();}}
    

    void felt11(){
    
        System.out.println("(**) komm.vég");
        felt1();}
    

    void felt12(){
    
        System.out.println(":-t talált");
        index++;switch (bemenet.charAt(index)) {
            case '=' -> felt13();
            case '$' -> felt19();
            default -> felt20();}}
    

    void felt13(){
    
        System.out.println(":= token");
        felt1();}
    

    void felt14(){
    
        System.out.println("<-t talált");
        index++;switch (bemenet.charAt(index)) {
            case '=' -> felt15();
            case '>' -> felt16();
            case '$' -> felt20();
            default -> felt20();}}
    

    void felt15(){
    
        System.out.println("<= token");
        felt1();}
    

    void felt16(){
    
        System.out.println("<> token");
        felt1();}
    

    void felt17(){
    
        System.out.println(">-t talált");
        index++;switch (bemenet.charAt(index)) {
            case '=' -> felt18();
            case '$' -> felt19();
            default -> felt20();}}
        

    void felt18(){
    
        System.out.println(">= token");
        felt1();}
    
    
    void felt19(){
    
        System.out.println("hibakezelő: "+bemenet.charAt(index));
        felt1();}
    

    void felt20(){
    
        System.out.println("továbbfejl.");
        index--;
        felt1();}
    

    void felt21(){
    
        System.out.println("vége");}}
    

        
    

    

