package lk.andunaechomedia.services.impl;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.dtos.mapper.GroupMapper;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private DeviceGroupRepo groupRepo;

    @Autowired
    private MainScheduleRepo mainScheduleRepo;

    public SaveGroupDto saveGroup(SaveGroupDto group) {

        MainSchedule mainSchedule =mainScheduleRepo.findById(group.getScheduleId()).get();
        DeviceGroup g= GroupMapper.mapToModel(group);
        g.setMainSchedule(mainSchedule);
        groupRepo.save(g);
        System.out.println("____________"+"save"+"________________");
        return group;
    }
}
