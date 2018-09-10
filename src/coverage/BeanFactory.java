/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage;

import coverage.StaticData;
import coverage.src.SrcBean;
import coverage.sum.FileBean;

/**
 * return a src bean instance based on the string 
 * @author Galaxy Yang
 */
public class BeanFactory {
  
    public static SrcBean getSrcBeanInstance(String[] args){
        Double Line_T=Double.parseDouble(args[2]);
        Double Line_C=Double.parseDouble(args[3]);
        Integer Line_t=Integer.parseInt(args[2]);
        Integer Line_c=Integer.parseInt(args[3]);
        Double cpl=Line_C/Line_T;
        String pl=StaticData.getPercent(cpl);
        
        Double Frag_T=Double.parseDouble(args[4]);
        Double Frag_C=Double.parseDouble(args[5]);
        Integer Frag_t=Integer.parseInt(args[4]);
        Integer Frag_c=Integer.parseInt(args[5]);
        Double cpf=Frag_C/Frag_T;
        String pf=StaticData.getPercent(cpf);
        
        return new SrcBean(args[0],args[1],cpl,pl
                  ,cpf,pf,Line_t,Line_c,Frag_t,Frag_c);
    }
    
    
    public static FileBean getFileBeanInstance(String[] args){
        int index=Integer.parseInt(args[0]);
        double clv=Double.parseDouble(args[3]);
        String clv_string=StaticData.getPercent(clv);
        
        return new FileBean(true,index,args[1],args[2],clv,clv_string);
    }
    
}
