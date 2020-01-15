package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public  class Device {
    @Id
    String device_id;
    String customer_name;
    String start_point;
    String end_point;
    String device_address;
    String tel_number;
    Date   publish_date;


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


}
