package lk.andunaechomedia.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "device")
@Getter
@Setter
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
    @JoinColumn(name = "device_group_id")
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
