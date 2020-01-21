package lk.andunaechomedia.models;

import org.springframework.boot.context.properties.ConfigurationProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "file")
@ConfigurationProperties(prefix = "file")
public class File implements Serializable {
    @Id
    @Column(name = "file_id")
    String file_id;
    String file_path;
    Date start_time;//time
    Date end_time;//time

    @ManyToMany(mappedBy = "file")
    Set<Main_schedule> mainSchedule;

    @ManyToMany(mappedBy = "file")
    Set<Temp_schedule> tempSchedule;

    public Set<Temp_schedule> getTempSchedule() {
        return tempSchedule;
    }

    public void setTempSchedule(Set<Temp_schedule> tempSchedule) {
        this.tempSchedule = tempSchedule;
    }

    public Set<Main_schedule> getMainSchedule() {
        return mainSchedule;
    }

    public void setMainSchedule(Set<Main_schedule> mainSchedule) {
        this.mainSchedule = mainSchedule;
    }

    public String getFile_id(){
        return file_id;
    }
    public void setFile_id(String file_id){
        this.file_id=file_id;
    }

    public String getFile_path(){

        return file_path;
    }
    public void setFile_path(String file_path){

        this.file_path=file_path;
    }

    public Date getStart_time(){

        return start_time;
    }
    public void setStart_time(Date start_time){

        this.start_time=start_time;
    }

   public Date getEnd_time(){

        return end_time;
    }
   public void setEnd_time(Date end_time){

        this.end_time=end_time;
    }

}
