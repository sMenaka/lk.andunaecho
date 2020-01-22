package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
public  class Device {
    @Id
    private String device_id;
    private String customer_name;
    private String start_point;
    private String end_point;
    private String device_address;
    private String tel_number;
    private Date   publish_date;
    @ManyToOne
    @JoinColumn(name="device_group_group_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="device_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("group_id")
    private Device_group device_group;

    public Device() {
    }

    public Device(String device_id,String customer_name,String start_point, String end_points, String device_address, String tel_number, Date publish_date) {
        this.setDevice_id(device_id);
        this.setCustomer_name(customer_name);
        this.setStart_point(start_point);
        this.setEnd_point(end_points);
        this.setDevice_address(device_address);
        this.setTel_number(tel_number);
        this.setPublish_date(publish_date);

    }

    public Device_group getDevice_group() {
        return device_group;
    }

    public void setDevice_group(Device_group device_group) {
        this.device_group = device_group;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public String getDevice_address() {
        return device_address;
    }

    public void setDevice_address(String address) {
        this.device_address = address;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String telphone) {
        this.tel_number = telphone;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    /*public void updatePartial(Device device, String deice_id){
        Device newDevice = deviceRepo.findOne(device_id);
        if (device.getCustomer_name() != null){
            newDevice.setCustomer_name(device.getCustomer_name());
        }
        if (device.getStart_point() != null){
            newDevice.setStart_point(device.getStart_point());
        }
        if (device.getEnd_point() != null){
            newDevice.setEnd_point(device.getEnd_point());
        }
        if (device.getDevice_address() != null){
            newDevice.setDevice_address(device.getDevice_address());
        }
        if (device.getTel_number() != null){
            newDevice.setTel_number(device.getTel_number());
        }
        if (device.getPublish_date() != null){
            newDevice.setPublish_date(device.getPublish_date());
        }
    }*/


}
