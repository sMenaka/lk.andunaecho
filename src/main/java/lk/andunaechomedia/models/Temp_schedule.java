package lk.andunaechomedia.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "temp_schedule")
public class Temp_schedule implements Serializable {

    @Id
    @Column(name = "temp_id")
    String temp_id;
    String version;

    @ManyToMany
    @JoinTable(name = "temp_schedule_has_file", joinColumns = {@JoinColumn(name = "schedule_id", referencedColumnName = "temp_id")}, inverseJoinColumns = {@JoinColumn(name = "file_id", referencedColumnName = "file_id")})
    Set<File> file;

    public Set<File> getFile() {
        return file;
    }

    public void setFile(Set<File> file) {
        this.file = file;
    }

    public String getTemp_id() {
        return temp_id;
    }

    public void setTemp_id(String temp_id) {
        this.temp_id = temp_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
