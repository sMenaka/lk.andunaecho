package lk.andunaechomedia.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "main_schedule")
public class MainSchedule implements Serializable{
    private static final long serialVersionUID = 1L;
    public MainSchedule() {

    }

    public MainSchedule(String scheduleId) {
        this.scheduleId=scheduleId;
    }

    @Id
    private String scheduleId;
    private double version;
    @JsonBackReference(value = "MainScheduleHasFile-MainSchedule")
    @OneToMany(mappedBy = "mainSchedule",cascade = {CascadeType.ALL})
    private Set<MainScheduleHasFile> mainScheduleHasFile;
    @JsonBackReference(value = "DeviceGroup-MainSchedule")
    @OneToMany(mappedBy = "mainSchedule", cascade = {
            CascadeType.ALL
    })
    private Set<DeviceGroup> groups;


    public Set<MainScheduleHasFile> getMainScheduleHasFile() {
        return mainScheduleHasFile;
    }

    public void setMainScheduleHasFile(Set<MainScheduleHasFile> mainScheduleHasFile) {
        this.mainScheduleHasFile = mainScheduleHasFile;
    }

    public Set<DeviceGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<DeviceGroup> groups) {
        this.groups = groups;
    }

    public String getScheduleId(){

        return scheduleId;
    }
    public void setScheduleId(String schedule_id){

        this.scheduleId =schedule_id;
    }

    public double getVersion() {

        return version;
    }
    public void setVersion(String version){

        this.version=Double.parseDouble(version);
   }


}
