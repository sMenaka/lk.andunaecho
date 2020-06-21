package lk.andunaechomedia.dtos.mapper;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.models.DeviceGroup;

public class GroupMapper {
   static public DeviceGroup mapToModel(SaveGroupDto groupDto){
        DeviceGroup group=new DeviceGroup();
        group.setGroupId(groupDto.getGroupId());
        group.setGroupName(groupDto.getName());
        return    group;
    }
}
