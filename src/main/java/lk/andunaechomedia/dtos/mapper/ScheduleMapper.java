package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.MainSchedule;

public class ScheduleMapper {
    static public MainSchedule mapToModel(SaveScheduleDto scheduleDto){
        MainSchedule mainSchedule = new MainSchedule();
        mainSchedule.setScheduleId(scheduleDto.getScheduleId());
        mainSchedule.setVersion(scheduleDto.getVersion());
        return mainSchedule;
    }
    static public GetVersionDto mapToGetVersionDto(MainSchedule schedule){
        GetVersionDto version=new GetVersionDto();
        version.setCurrentVersion(schedule.getVersion());
        return version;

    }
}
