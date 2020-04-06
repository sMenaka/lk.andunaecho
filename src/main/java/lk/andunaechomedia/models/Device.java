package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "device")
public  class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String deviceId;
    private String customerName;
    private String startPoint;
    private String endPoint;
    private String deviceAddress;
    private String telNumber;
    Date publishDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_group_group_id")
    private DeviceGroup deviceGroup;

    public Device() {
    }

    public Device(String device_id,String customer_name,String start_point, String end_points, String device_address, String tel_number, Date publish_date) {
        this.setDeviceId(device_id);
        this.setCustomerName(customer_name);
        this.setStartPoint(start_point);
        this.setEndPoint(end_points);
        this.setDeviceAddress(device_address);
        this.setTelNumber(tel_number);
        this.setPublishDate(publish_date);

    }

    public DeviceGroup getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(DeviceGroup device_group) {
        this.deviceGroup = device_group;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String device_id) {
        this.deviceId = device_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String start_point) {
        this.startPoint = start_point;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String end_point) {
        this.endPoint = end_point;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String address) {
        this.deviceAddress = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telphone) {
        this.telNumber = telphone;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publish_date) {
        this.publishDate = publish_date;
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
