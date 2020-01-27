package lk.andunaechomedia.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "main_schedule_has_file")
public class MainScheduleHasFile implements Serializable {
    private static final long serialVersionUID = 1L;
    public MainScheduleHasFile() {
    }





    @Id
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    MainSchedule mainSchedule;
    @Id
    @ManyToOne
    @JoinColumn(name = "file_id")
    File file;

    Integer playPoint;



    public MainSchedule getMainSchedule() {
        return mainSchedule;
    }

    public void setMainSchedule(MainSchedule mainSchedule) {
        this.mainSchedule = mainSchedule;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Integer getPlayPoint() {
        return playPoint;
    }

    public void setPlayPoint(Integer playPoint) {
        this.playPoint = playPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainScheduleHasFile that = (MainScheduleHasFile) o;
        return Objects.equals(mainSchedule, that.mainSchedule) &&
                Objects.equals(file, that.file) &&
                Objects.equals(playPoint, that.playPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainSchedule, file, playPoint);
    }
}
