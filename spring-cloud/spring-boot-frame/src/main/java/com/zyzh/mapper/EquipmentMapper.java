package com.zyzh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyzh.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description com.zyzh.mapper.EquipmentMapper
 * @Created by zhouxiaoyuan on 2021/4/25 13:39
 */
@Mapper
public interface EquipmentMapper extends  BaseMapper<Equipment>{

    void cleanShowFlag(String type);
    void setShowFlag(String showType,String type,String ids);
    void updateEquipmentStatus(String id,String status);

    List findByCondition( Boolean notParentFlag ,String parentId ,String type,String name ,String start, String count ,String extConditon);

    Equipment getOne(String id);


}
