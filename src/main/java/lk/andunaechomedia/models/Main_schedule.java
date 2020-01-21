package lk.andunaechomedia.models;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "main_schedule")
public class Main_schedule implements Serializable{

    @Id
    @Column(name = "schedule_id")
    String schedule_id;
    String version;

    @ManyToMany
    @JoinTable(name = "main_schedule_has_file", joinColumns = {@JoinColumn(name = "schedule_id",referencedColumnName = "schedule_id")}, inverseJoinColumns = {@JoinColumn(name = "file_id",referencedColumnName = "file_id")})
    Set<File> file;

    public Set<File> getMainScheduleData() {
        return file;
    }

    public void setMainScheduleData(Set<File> mainScheduleData) {

        this.file = mainScheduleData;
    }


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
