/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    
    
    public static String getPercent(Double per){
        NumberFormat nf=NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);
        String s=nf.format(per);
         return  s;
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
        br.close();
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
    
    /**
     * 20180829 10:27
     * 获取当前日期
     * @return  String date
     */
    public static String getDate(){
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

     public static BufferedReader readDocFile(String filepath)throws IOException{
         File file=new File(filepath);
         BufferedReader br=new BufferedReader(new FileReader(file));
         return br;
     }
     
     /**
      * 20180828 19:10
      * 作为UTIL类提供公共复用
      * @param content
     * @param file
      * @throws IOException 
      */
     public static void outputContent(String content,File file)throws IOException{
         if(!file.exists()){
             file.createNewFile();
         }
         FileWriter fw=new FileWriter(file,true);
         fw.write(content);
         fw.write("\r\n");
         fw.flush();
         fw.close();
         file.deleteOnExit();
     }
     
     
     
     /**
      * 20180829 10:53
      * 用两个整型获得双浮点百分比
      * @param total
      * @param part
      * @return percent
      */
     
     public static Double calculatePer(int total,int part){
         
         double res=(double)part/total;
         Double result=(double)Math.round(res*100)/100;
         return result;
     }
   
}
