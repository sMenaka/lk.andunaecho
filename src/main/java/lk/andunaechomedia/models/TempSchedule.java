package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "temp_schedule")
public class TempSchedule implements Serializable {


    @Id
    String tempId;
    String version;
    @JsonBackReference(value = "DeviceGroup-TempSchedule")
    @OneToMany(mappedBy = "tempSchedule", cascade = {
            CascadeType.ALL
    })
    private Set<DeviceGroup> groups;

    @JsonBackReference(value = "TempScheduleHasFile-TempSchedule")
    @OneToMany(mappedBy = "tempSchedule",cascade = {CascadeType.ALL})
    private Set<TempScheduleHasFile> tempScheduleHasFiles;


    public Set<TempScheduleHasFile> getTempScheduleHasFiles() {
        return tempScheduleHasFiles;
    }

    public void setTempScheduleHasFiles(Set<TempScheduleHasFile> tempScheduleHasFiles) {
        this.tempScheduleHasFiles = tempScheduleHasFiles;
    }

    public Set<DeviceGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<DeviceGroup> groups) {
        this.groups = groups;
    }



    public String getTempId() {
        return tempId;
    }

    public void setTempId(String temp_id) {
        this.tempId = temp_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
