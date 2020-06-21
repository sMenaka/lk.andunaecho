package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.MainSchedule;

public class ScheduleMapper {
    static public MainSchedule mapToModel(SaveScheduleDto scheduleDto){
        MainSchedule mainSchedule = new MainSchedule();
        mainSchedule.setScheduleId(scheduleDto.getScheduleId());
        mainSchedule.setVersion(scheduleDto.getVersion());
        return mainSchedule;
    }
}
