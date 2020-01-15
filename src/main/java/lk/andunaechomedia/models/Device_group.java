package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device_group {
   @Id
    String group_id;
    String group_name;
    String main_schedule_schedule_id;
    String temp_schedule_temp_id;


     public String getGroup_id(){ return group_id; }
     public void setGroup_id(String group_id){
      this.group_id=group_id;
     }

    public String getGroup_name(){
      return group_name;
     }
    public void setGroup_name(String group_name){
      this.group_name=group_name;
     }

    public String getMain_schedule_schedule_id(){
      return main_schedule_schedule_id;
     }
    public void setMain_schedule_schedule_id(String main_schedule_schedule_id){
      this.main_schedule_schedule_id=main_schedule_schedule_id;
     }

    public String getTemp_schedule_temp_id(){
      return temp_schedule_temp_id;
     }
    public void setTemp_schedule_temp_id(String temp_schedule_temp_id){
      this.temp_schedule_temp_id=temp_schedule_temp_id;
     }
}
