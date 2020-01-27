package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File,String> {

}
