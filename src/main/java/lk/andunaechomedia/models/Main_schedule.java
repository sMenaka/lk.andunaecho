package lk.andunaechomedia.models;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Id;

@Eager
public class Main_schedule {
@Id
    String schedule_id;
    String version;

    public String getSchedule_id(){
        return schedule_id;
    }
    public void setSchedule_id(String schedule_id){
        this.schedule_id=schedule_id;
    }

    public String getVersion() {
        return version;
    }
   public void setVersion(String version){
        this.version=version;
   }

}
