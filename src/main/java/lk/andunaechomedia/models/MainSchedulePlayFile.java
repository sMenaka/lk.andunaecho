package lk.andunaechomedia.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
@IdClass(lk.andunaechomedia.models.MainSchedulePlayFile.class)
@Entity
@Table(
    name = "main_schedule_play_file"
)
public class MainSchedulePlayFile implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(
        name = "schedule_id"
    )
    private MainSchedule mainSchedule;
    @Id
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(
        name = "file_id"
    )
    private File file;
    private Integer playPoint;

    public MainSchedulePlayFile() {
    }

    public MainSchedulePlayFile(MainSchedule mainSchedule, File file,Integer playPoint) {
        this.mainSchedule = mainSchedule;
        this.file = file;
        this.playPoint=playPoint;
    }

    public MainSchedule getMainSchedule() {
        return this.mainSchedule;
    }

    public void setMainSchedule(MainSchedule mainSchedule) {
        this.mainSchedule = mainSchedule;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Integer getPlayPoint() {
        return this.playPoint;
    }

    public void setPlayPoint(Integer playPoint) {
        this.playPoint = playPoint;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            MainSchedulePlayFile that = (MainSchedulePlayFile)o;
            return Objects.equals(this.mainSchedule, that.mainSchedule) && Objects.equals(this.file, that.file) && Objects.equals(this.playPoint, that.playPoint);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mainSchedule, this.file, this.playPoint});
    }
}
