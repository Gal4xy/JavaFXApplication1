/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.ArrayList;
import  javafxapplication1.StaticData;
/**
 *
 * @author Galaxy Yang
 */
public class test {
      
    private List<String> list;
    
    public test(){
        list=new ArrayList<String>();
    }
    
    public static void main(String[] args){
        StaticData sd=new StaticData();
        test t=new test();
        
      try{
     sd.getContext();}
       catch(Exception e){
       e.printStackTrace();
    }
        sd.calculate();
        System.out.println(" result ee "+sd.getProgressLine()+" date "+sd.getDate());
        
        
    }
}