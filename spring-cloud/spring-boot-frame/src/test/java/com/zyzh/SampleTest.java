package com.zyzh;

import com.zyzh.entity.Equipment;
import com.zyzh.mapper.EquipmentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description PACKAGE_NAME.SampleTest
 * @Created by zhouxiaoyuan on 2021/4/25 13:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Test
    public void testSelect(){
        System.out.println("----------- selectAll method test -----------");
        List<Equipment> equipmentList = equipmentMapper.selectList(null);
//        Assert.assertEquals();
        equipmentList.forEach(System.out::println);
    }
}
