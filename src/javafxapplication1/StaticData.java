/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.lang.ArithmeticException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Galaxy Yang
 */
public class StaticData {
    
    private static final String filepath="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\WHETS.objcov";
    private double progress=0.5;
    private ArrayList<String> list;
    
    
    public StaticData(){
        list=new ArrayList<String>();
    }
    
    public double getProgress(){
        Double dou=(double)Math.round(progress*100)/100;
        return dou;
    }
    // read
    public void getContext() throws IOException{
     if(list!=null){
        File f=new File(filepath);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           list.add(s);
       } 
        System.out.println(list.size());
     }
     else{
           System.out.println("Error_listEmpty");
     }
    }
    
    //calculator 
    public void calculate() throws ArithmeticException{
        
        if(list!=null){
            String[] lineData=list.get(0).split("#");
            Double totalLine=Double.parseDouble(lineData[0]);
            Double hitLine=Double.parseDouble(lineData[1]);
              if(totalLine!=0.0){ 
              progress=hitLine/totalLine;}
              else{
                  System.out.println("Error_TotalLineZero"); 
              }
        
        }
        
        else{
            System.out.println("Error_listEmpty");
        }
        
        
        
    }
    
    //read date
    public String getDate(){
        Date d = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        String dateNowStr = sdf.format(d);  
        return dateNowStr;        
    }
    
    
    //return total number 
    public String getTotalLineNumber(){
        return list.get(0).split("#")[0];
    }
    
    //return hit line 
    public String getHitLineNumer(){
        return list.get(0).split("#")[1];
    }
    
    
}
