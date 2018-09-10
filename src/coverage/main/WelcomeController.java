/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.main;

import coverage.CovConstants;
import coverage.StaticData;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.commons.io.FileUtils;


/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class WelcomeController implements Initializable {

     private Coverage application;
     private List<String> list;
     private String filepath=null;
     private String PrgName=null;
     private Integer sumTotalLine=0;
     private Integer sumCovLine=0;
     private Double sumPercent=00.00;

     
     
  
    
    
     public WelcomeController() throws IOException{
       list=new ArrayList<>();
       filepath=CovConstants.INITPATH;
         
     }  
     
     public void setApp(Coverage application){
        this.application=application;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *   20180827 19:25 在WELCOME页面对Path进行处理得到SrcPath和ObjPath
         */
        
       
        try{
        this.producePathFile(filepath);
        CovConstants.PrjName=PrgName; 
        //this.moveTempFile(PrgName);
        this.createSumList(PrgName);
            }
        catch (IOException ex) {
            
        }
    }
    
       @FXML 
    protected void handleStartButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
   
        @FXML 
    protected void handleStartsrcButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndexSrc();}
    }
    
    
    /**
     *  added by Galaxy 15:18
     * @param event
     */
     @FXML 
    protected void handleSrcPathButtonAction(ActionEvent event) {
     
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
     @FXML 
    protected void handleSrcCovPathButtonAction(ActionEvent event) {
     
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
     @FXML 
    protected void handleObjCovButtonAction(ActionEvent event) {
      
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
    

    public void getContext(String filepath) throws IOException{
     if(list!=null){
        File f=new File(filepath);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           list.add(s);
           } 
        System.out.println(" SIZE "+list.size());
     }
     else{
           System.out.println("Error_listEmpty");
     }
    }
        
    
    public List<String> getList(){
        return list;
    }
 

   /**
    * 20180827 15:28
    * 对Path文档进行分析分别产生记录文件SrcFilePath和ObjFilePath
    * @param filepath C://Path//Path.txt
    * @throws IOException
    */
     public void producePathFile(String filepath) throws IOException{
          File file=new File(filepath);
          BufferedReader br=new BufferedReader(new FileReader(file));
          String s;
          while((s=br.readLine())!=null){
               String[] args=s.split("#");
                 if(args!=null){
                     if(args[0].equals("SRC")){
                           createSrcList(args[1],args[2],args[3]);
                     }
                     if(args[0].equals("OBJ")){
                           createObjList(args[1],args[2],args[3]);      
                     }
                     if(args[0].equals("PRJNAME")){
                              this.PrgName=args[1];
                     }
                 }
           }
          br.close();
            
           sumPercent=StaticData.calculatePer(sumTotalLine,sumCovLine);
        
     }
    
    /**
     *  20180828 15;07
     * 
     * 形成字符串数组 WHETS/WHET/149/88/98/67
     * 然后调用output输出内容到指定文件SrcPath
     * 
     * @param filepath srcccov文件的路径
     * @param CName   源文件名称
     * @param PrjName 项目名称
     * @throws IOException
     */  
     public void createSrcList(String filepath,String CName,String PrjName)throws IOException{
        
         File file=new File(filepath);
         BufferedReader br=new BufferedReader(new FileReader(file));
         String s;
         String[] Args=new String[6];//声明一个用于填写最终文档的字符串数组
         ArrayList<String> ArgsArray;
         ArgsArray = new ArrayList<>();
         ArgsArray.add(CName);
         ArgsArray.add(PrjName);
         
          while((s=br.readLine())!=null){
              if(s.contains("#")){
                   String[] args=s.split("#");
                   ArgsArray.add(args[0]);
                   ArgsArray.add(args[1]);
               }
          }
          
            Args=ArgsArray.toArray(new String[6]);
            String content=Args[0]+"#"+
                 Args[1]+"#"+Args[2]+"#"+Args[3]+"#"+Args[4]+"#"
                 +Args[5];
            
            sumTotalLine=sumTotalLine+Integer.parseInt(Args[2]);
            sumCovLine=sumCovLine+Integer.parseInt(Args[3]);
          
               
             File finalfile=new File(CovConstants.init_src_path);
             if(!finalfile.exists()){
                finalfile.createNewFile();
              }
            StaticData.outputContent(content,finalfile );
                
     }
     
     /**
      * 20180827 19:30
      */
     public void createObjList(String filepath,String CName,String PrjName){
         
     }
     
     
     
    
     
     /**20180828 1852 移动
      * cautions:要在producepathfile之后运行 这样PRJNAME不会为空
      * @param PrjName 
      */
     public void moveTempFile(String PrjName) throws IOException{
         String SdestDir=System.getProperty("user.home")+File.separator+"IDE_WORKSPACE"+File.separator+PrjName;
         String SsrcFile=CovConstants.TEMPCOVPATH;
         File destDir=new File(SdestDir);
         File srcFile=new File(SsrcFile);
         if(!srcFile.exists()){
             srcFile.createNewFile();
         }
         FileUtils.moveFileToDirectory(srcFile, destDir, true);
         
     }
     
     
     /**
      * 20180829 10:22
      * 读取文件内容为List 修改内容为contentList 写入
     * @param PrjName 工程文件的路径
     * @throws java.io.IOException
      */
     
     public void createSumList(String PrjName) throws IOException{
         int count=0;
         String scount=null;
         String content=null;
         List<String> contentList=new ArrayList<>();
       
         /**
          * 0829 1530 
        
         String destDir=System.getProperty("user.home")+File.separator+"IDE_WORKSPACE"
                 +File.separator+PrjName+File.separator+"log.txt";  */
         String destDir="C:\\Path\\log.txt";
                  String path="Path";
        
          File file=new File(destDir);
         if(!file.exists()){
             file.createNewFile();
         }
    
         //output
         List<String> list=FileUtils.readLines(file,"UTF-8");
         
         content=StaticData.getDate()+"#"+PrjName+"#"+this.sumPercent+"#"+path;;
         
        
            if(list.isEmpty()){
                contentList.add("1");
                String s="1"+"#"+content;
                contentList.add(s);
            }
            else{       
                count=Integer.parseInt(list.get(0))+1;
                scount=""+count;
                list.remove(0);
                contentList.add(scount);
                contentList.addAll(list);
                String s=scount+"#"+content;
                contentList.add(s);
            }
            
            FileUtils.writeLines(file, contentList);
     } 
     
     
    
}
