/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.sum;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Galaxy Yang
 */
public class FileBean {
    
    private final SimpleBooleanProperty check;
    private final SimpleStringProperty date;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty index;
    private final SimpleDoubleProperty cov;
    private final SimpleStringProperty per;
    
    public FileBean(Boolean check,int index,String date,String name,Double cov,String per){
        this.check=new SimpleBooleanProperty(check);
        this.date=new SimpleStringProperty(date);
        this.name=new SimpleStringProperty(name);
        this.index=new SimpleIntegerProperty(index);
        this.cov=new SimpleDoubleProperty(cov);
        this.per=new SimpleStringProperty(per);
    }

    public Boolean getCheck() {
        return check.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getName() {
        return name.get();
    }

    
    public String getPer() {
        return per.get();
    }
    public int getIndex() {
        return index.get();
    }

    public Double getCov() {
        return cov.get();
    }
    
    public void setName(String s){
        this.name.set(s);
    }
    
    public void setDate(String s){
        this.date.set(s);
    }
    
    public void setPer(String s){
        this.per.set(s);
    }
    
    public void setCheck(Boolean b){
        this.check.set(b);
    }
    
    public void setIndex(int i){
        this.index.set(i);
    }
    public void setCov(Double d){
        this.cov.set(d);
    }
    
}
