package lk.andunaechomedia.repositories;

import lk.andunaechomedia.models.MainSchedulePlayFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MainSchedulePlayFileRepo extends JpaRepository<MainSchedulePlayFile,String> {
    @Query(value="DELETE FROM `anduna_echo`.`main_schedule_play_file` WHERE `schedule_id` =:schedule",nativeQuery = true)
    void deleteByMainSchedule(String schedule);
}
