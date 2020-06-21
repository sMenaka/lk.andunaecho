package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;

public class GroupMapper {

   static public DeviceGroup mapToModel(SaveGroupDto groupDto){
        DeviceGroup group=new DeviceGroup();
        group.setGroupId(groupDto.getGroupId());
        group.setGroupName(groupDto.getName());

        return  group;
    }
}
