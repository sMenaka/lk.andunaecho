package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "device_group")

public class DeviceGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    public DeviceGroup() {
    }

    public DeviceGroup(String groupId) {
        this.groupId=groupId;
    }

    @Id
    private String groupId;
    private String groupName;
    @JsonBackReference (value = "Device-DeviceGroup")
    @OneToMany(mappedBy = "deviceGroup", cascade = {
            CascadeType.ALL
    })
    private Set<Device> devices;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "main_schedule_id")
    private MainSchedule mainSchedule;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "temp_schedule_schedule_id")
//    private TempSchedule tempSchedule;
//
//    public TempSchedule getTempSchedule() {
//        return tempSchedule;
//    }
//
//    public void setTempSchedule(TempSchedule tempSchedule) {
//        this.tempSchedule = tempSchedule;
//    }

    public MainSchedule getMainSchedule() {
        return mainSchedule;
    }

    public void setMainSchedule(MainSchedule mainSchedule) {
        this.mainSchedule = mainSchedule;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public String getGroupId(){ return groupId; }
    public void setGroupId(String group_id){
        this.groupId =group_id;
    }

    public String getGroupName(){
        return groupName;
    }
    public void setGroupName(String group_name){
        this.groupName =group_name;
    }


}