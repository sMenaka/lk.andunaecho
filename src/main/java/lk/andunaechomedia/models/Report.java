package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Report {
@Id
    String report_id;
    String report_path;
    Date report_date;//date

   public String getReport_id(){
       return report_id;

   }
   public void setReport_id(String report_id){

       this.report_id=report_id;
   }
   public String getReport_path(){
       return report_path;

   }
   public void setReport_path(String report_path){
       this.report_path=report_path;

   }

   public Date getReport_date(){

       return report_date;
   }
   public void setReport_date(Date report_path){
       this.report_date=report_date;
   }

}
