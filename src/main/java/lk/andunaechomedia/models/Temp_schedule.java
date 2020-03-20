package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Temp_schedule {

@Id

    String temp_id;
    String version;


    public String getTemp_id(){
        return temp_id;
    }
   public void setTemp_id(String temp_id){
        this.temp_id=temp_id;
   }

   public String getVersion(){
        return version;

   }
   public void setVersion(String version){
        this.version=version;
   }
}
