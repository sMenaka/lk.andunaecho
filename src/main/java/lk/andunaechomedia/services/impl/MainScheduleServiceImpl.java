package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.dtos.mapper.ScheduleMapper;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.MainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainScheduleServiceImpl implements MainScheduleService {
    @Autowired
    MainScheduleRepo mainScheduleRepo;
    @Override
    public SaveScheduleDto save(SaveScheduleDto scheduleDto) {
         mainScheduleRepo.save(ScheduleMapper.mapToModel(scheduleDto));
        return scheduleDto;
    }
}
