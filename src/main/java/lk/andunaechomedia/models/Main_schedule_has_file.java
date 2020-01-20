package lk.andunaechomedia.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Main_schedule_has_file {
    @Id
    String schedule_id;
    String file_id;
    String file_start_time;

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getFile_start_time() {
        return file_start_time;
    }

    public void setFile_start_time(String file_start_time) {
        this.file_start_time = file_start_time;
    }
}
