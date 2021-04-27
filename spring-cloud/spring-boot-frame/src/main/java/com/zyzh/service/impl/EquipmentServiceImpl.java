package com.zyzh.service.impl;

import com.zyzh.commons.constant.Constant;
import com.zyzh.commons.model.OperateResult;
import com.zyzh.entity.Equipment;
import com.zyzh.mapper.EquipmentMapper;
import com.zyzh.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description com.yunkouan.riskInterceptEntry.modules.equipment.service.impl.EquipmentServiceImpl
 * @Created by zhouxiaoyuan on 2021/4/14 9:19
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private EquipmentMapper equipmentMapper;


    @Override
    public OperateResult add(Equipment equipment) {
        OperateResult result = new OperateResult();
        result.setStatus(Constant.OperateResultConstant.STATUS_SUCCEEDED);
        try {
            equipment.setDeleteStatus(EquipmentService.DELETE_STATUS.EXIST.getValue());
            equipment.setCreateTime(new Date());
            equipment.setUpdateTime(new Date());
            equipmentMapper.insert(equipment);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(Constant.OperateResultConstant.STATUS_FAILED);
        }
        return result;
    }

    @Override
    public OperateResult update(Equipment equipment) {
        OperateResult result = new OperateResult();
        result.setStatus(Constant.OperateResultConstant.STATUS_SUCCEEDED);
        try {
            equipment.setUpdateTime(new Date());
            equipment.setDeleteStatus(DELETE_STATUS.EXIST.getValue());
            equipmentMapper.updateById(equipment);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(Constant.OperateResultConstant.STATUS_FAILED);
        }
        return result;
    }

    @Override
    public OperateResult delete(String id) {
        OperateResult result = new OperateResult();
        result.setStatus(Constant.OperateResultConstant.STATUS_SUCCEEDED);
        try {
            equipmentMapper.deleteById(id);
        } catch (Exception e) {
            result.setStatus(Constant.OperateResultConstant.STATUS_FAILED);
        }
        return result;
    }

    @Override
    public Equipment findById(String id) {
        return equipmentMapper.selectById(id);
    }

    @Override
    @Transactional
    public OperateResult setCameraFirstPageShowByIds(String[] ids) {
        OperateResult result = new OperateResult();
        result.setStatus(Constant.OperateResultConstant.STATUS_SUCCEEDED);
        if(ids==null||ids.length<1){
            return result;
        }
        try {
            //清除之前的记录
            equipmentMapper.cleanShowFlag(EQUIPMENT_TYPE.CAMERA.getValue() );
            int iMax = ids.length - 1;
            StringBuilder b = new StringBuilder();
            for (int i = 0; ; i++) {
                b.append(ids[i]);
                if(i == iMax){
                    break;
                }
                b.append(",");
            }
            setCameraFirstPageShow(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(Constant.OperateResultConstant.STATUS_FAILED);
        }
        return result;
    }

    public void setCameraFirstPageShow(String id) {
        equipmentMapper.setShowFlag( EquipmentService.CAMERA_FIRST_SHOW.SHOW.getValue(),EQUIPMENT_TYPE.CAMERA.getValue(),id);
    }

    @Override
    public List<Equipment> findCameraFirstPageShow() {
        return findByCondition(null, EquipmentService.EQUIPMENT_TYPE.CAMERA.getValue(), null, null, null, " AND show_flag =" + EquipmentService.CAMERA_FIRST_SHOW.SHOW.getValue() );

    }

    @Override
    public void updateEquipmentStatus(String id, String status) {
        equipmentMapper.updateEquipmentStatus(id, status);
    }

    @Override
    public List<Equipment> findCameraGroup(){
        return findByCondition(NODE_TYPE.VIRTUAL.getValue(), EquipmentService.EQUIPMENT_TYPE.CAMERA.getValue(), null, null, null, null);
    }

    @Override
    public List<Equipment> findByParent(String id) {
        return findByCondition(id, null, null, null, null, null);
    }

    @Override
    public List findByCondition(String parentid,String type,String name ,String start, String count ,String extConditon){
        return equipmentMapper.findByCondition(parentid,type,name,start,count,extConditon);
    }

}
