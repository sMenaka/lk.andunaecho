package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class File {
    @Id
    String file_id;
    String file_path;
    Date start_time;//time
    Date end_time;//time


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
