package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(
    name = "main_schedule"
)
public class MainSchedule {
    @Id
    private String scheduleId;
    private int version;
    @JsonBackReference("MainScheduleHasFile-MainSchedule")
    @OneToMany(mappedBy = "mainSchedule", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private Set<MainSchedulePlayFile> mainSchedulePlayFile;
   @JsonBackReference("DeviceGroup-MainSchedule")
    @OneToMany(mappedBy = "mainSchedule",cascade = {CascadeType.ALL})
    private Set<DeviceGroup> groups;

    public MainSchedule() {
        this.mainSchedulePlayFile = new HashSet();
    }

    public MainSchedule(String scheduleId, int version) {
        this.scheduleId = scheduleId;
        this.version = version;
        this.mainSchedulePlayFile = new HashSet();
    }

    public Set<MainSchedulePlayFile> getMainSchedulePlayFile() {
        return this.mainSchedulePlayFile;
    }

    public void setMainSchedulePlayFile(Set<MainSchedulePlayFile> mainSchedulePlayFile) {
        this.mainSchedulePlayFile = mainSchedulePlayFile;
    }

    public Set<DeviceGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<DeviceGroup> groups) {
        this.groups = groups;
    }

    public String getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(String schedule_id) {
        this.scheduleId = schedule_id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version =version;
    }
}
