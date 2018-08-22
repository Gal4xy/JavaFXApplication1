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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;


/**
 *
 * @author Galaxy Yang
 */
public class StaticData {
    
   
    private double progressLine=0.5;
    private double progressF=0.5;
    private List<String> list;
    private Map<String,Integer> info;
    
    
    public StaticData(){
        list=new ArrayList<String>();
        info=new HashMap<String,Integer>();
    }
    
    public double getProgressLine(){
        Double dou=(double)Math.round(progressLine*100)/100;
        return dou;
    }
    
    public String getProgressLineStr(){
        
        NumberFormat nf=NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);
        String s=nf.format(this.progressLine);
         return  s;
    }
    
     public String getProgressfStr(){
        
        NumberFormat nf=NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);
        String s=nf.format(this.progressF);
         return  s;
    }
    
    public double getProgressF(){
         Double dou=(double)Math.round(progressF*100)/100;
          return dou;
    }
    
    // read
    public void getContext(String filepath) throws IOException{
     if(list!=null){
        File f=new File(filepath);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           list.add(s);
            if(s.length()>5){
               if(s.contains("*")){
                     System.out.println("SUCCESS-SPLIT");
                   String[] infos=s.split("\\*");
                           if(infos!=null){
                                   info.put(infos[0],Integer.parseInt(infos[2]));
                           }
                           else{
                               System.out.println("Error_StringsplitNUll");
                           }
               }
            }
           } 
        System.out.println(" SIZE "+list.size()+" MAP "+info.keySet().size());
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
            String[] fData=list.get(1).split("#");
            Double totalF=Double.parseDouble(fData[0]);
            Double hitf=Double.parseDouble(fData[1]);
              if(totalLine!=0.0&&totalF!=0){ 
              progressLine=hitLine/totalLine;
              progressF=hitf/totalF;}
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
    
    //return hit fragment
    public String getHitFNumber(){
        return list.get(1).split("#")[1];
    }
    
    //return total fragment
    public String getTotalFNumber(){
        return list.get(1).split("#")[0];
    }


    public Map<String,Integer> getMapInfo(){
        return this.info;
    }
    
    public List<String> getList(){
        return list;
    }
    
    public String getFilePath(){
        String filePath=null;
        
        return filePath;
    }
}
