package lk.andunaechomedia.services;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.MainSchedule;

public interface MainScheduleService {
    public SaveScheduleDto save(SaveScheduleDto scheduleDto);
    public GetVersionDto getCurrentVersion(String deviceId);

}
