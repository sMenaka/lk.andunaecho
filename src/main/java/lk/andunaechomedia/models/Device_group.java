package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Device_group {
   @Id
    private String group_id;
    private String group_name;
    @OneToMany(mappedBy = "device_group")
    @JsonManagedReference
    private Set<Device> devices;
    @ManyToOne
    @JoinColumn(name="device_group_group_id", nullable=false)

    private Main_schedule main_schedule;
    private String temp_schedule_temp_id;
    @JsonBackReference(value="user-movement")
    public Set<Device> getDevice() {
        return devices;
    }

    public void setDevice(Set<Device> devices) {
        this.devices = devices;
    }

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
    @JsonBackReference(value="user-movement")
    public Main_schedule getMain_schedule_schedule_id(){
      return main_schedule;
     }
    public void setMain_schedule_schedule_id(Main_schedule main_schedule){
      this.main_schedule=main_schedule;
     }

    public String getTemp_schedule_temp_id(){
      return temp_schedule_temp_id;
     }
    public void setTemp_schedule_temp_id(String temp_schedule_temp_id){
      this.temp_schedule_temp_id=temp_schedule_temp_id;
     }
}
