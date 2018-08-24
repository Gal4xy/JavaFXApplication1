/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.src;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;


/**
 *
 * @author Galaxy Yang
 */
public class SrcBean {
    
    
    private final SimpleStringProperty PrjNmae;
    private final SimpleStringProperty Name;
    private final SimpleDoubleProperty cov_lp;
    private final SimpleStringProperty per_p;
    private final SimpleDoubleProperty cov_fp;
    private final SimpleStringProperty per_f;
    private Integer Cov_L;
    private Integer Cov_F;
    private Integer Total_L;
    private Integer Total_F;
    
    public SrcBean(String n,String pn,Double cpl,String pl,
            Double cpf,String pf,int cl,int cf,int tf,int tl){
        this.PrjNmae=new SimpleStringProperty(pn);
        this.Name=new SimpleStringProperty(n);
        this.cov_lp=new SimpleDoubleProperty(cpl);
        this.per_p=new SimpleStringProperty(pl);
        this.cov_fp=new SimpleDoubleProperty(cpf);
        this.per_f=new SimpleStringProperty(pf);
      
        this.Cov_L=cl;
        this.Cov_F=cf;
        this.Total_F=tf;
        this.Total_L=tl;
    }
   
    public String getName() {
        return Name.get();
    }
    
     public String getPrjName() {
        return this.PrjNmae.get();
    }
     
     public void setName(String s){
        this.Name.set(s);
    }
     
     public void setPrjName(String s){
        this.PrjNmae.set(s);
    }
     
     
      public Double getLineProgress() {
        return this.cov_lp.get();
    }
     
      public void setLineProgress(Double d){
        this.cov_lp.set(d);
    }
      
      public Double getFProgress() {
        return this.cov_fp.get();
    }
      
      public void setFProgress(Double d){
        this.cov_fp.set(d);
    }

      
       public void setLinePer(String s){
        this.per_p.set(s);
    }
       
        public String getLinePer() {
        return this.per_p.get();
    }
        
        public void setFPer(String s){
        this.per_f.set(s);
    }
       
        public String getFPer() {
        return this.per_f.get();
    }
//        
        
      
    public Integer getCov_L() {
        return Cov_L;
    }

    public void setCov_L(Integer Cov_L) {
        this.Cov_L = Cov_L;
    }

    public Integer getCov_F() {
        return Cov_F;
    }

    public void setCov_F(Integer Cov_F) {
        this.Cov_F = Cov_F;
    }

    public Integer getTotal_L() {
        return Total_L;
    }

    public void setTotal_L(Integer Total_L) {
        this.Total_L = Total_L;
    }

    public Integer getTotal_F() {
        return Total_F;
    }

    public void setTotal_F(Integer Total_F) {
        this.Total_F = Total_F;
    }


}
