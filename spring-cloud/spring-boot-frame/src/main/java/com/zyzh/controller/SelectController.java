package com.zyzh.controller;

import com.zyzh.entity.Equipment;
import com.zyzh.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Description com.zyzh.controller.TestController
 * @Created by zhouxiaoyuan on 2021/4/25 14:27
 */
@Controller
public class SelectController {

    @Autowired
    EquipmentMapper equipmentMapper;

    @GetMapping("/getAllEquipment")
    @ResponseBody
    public List<Equipment> getAllEquipment(){
        return equipmentMapper.selectList(null);
    }


    @GetMapping("/insertEquipment")
    @ResponseBody
    public String  insertEquipment(){
        Equipment equipment = new Equipment();
        equipment.setName("手动插入");
        equipment.setParent("0");
        equipment.setCreateTime(new Date());
        equipment.setUpdateTime(new Date());
        equipment.setType("1");

        equipmentMapper.insert(equipment);
        return equipment.getId();
    }

}
