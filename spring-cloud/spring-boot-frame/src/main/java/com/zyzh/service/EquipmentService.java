package com.zyzh.service;


import com.zyzh.commons.model.OperateResult;
import com.zyzh.entity.Equipment;

import java.util.List;

/**
 * @Description com.yunkouan.riskInterceptEntry.modules.equipment.service.EquipmentService
 * @Created by zhouxiaoyuan on 2021/4/14 9:19
 */
public interface EquipmentService {

    //首页最大显示相机路数
    public static String CAMERA_FIRST_SHOW_MAX_NUMBER = "4";
    public static String EQUIPMENT_QUERY_FLAG = "-1";

    /**
     * @Author zhouxiaoyuan
     * @Description 添加
     * @Date 9:38 2021/4/14
     * @Param []
     * @return void
     **/
    public OperateResult add(Equipment equipment);

    /**
     * @Author zhouxiaoyuan
     * @Description 修改
     * @Date 9:39 2021/4/14
     * @Param []
     * @return void
     **/
    public  OperateResult update(Equipment equipment);

    /**
     * @Author zhouxiaoyuan
     * @Description 删除
     * @Date 9:39 2021/4/14
     * @Param []
     * @return void
     **/
    public  OperateResult delete(String id);

    /**
     * @Author zhouxiaoyuan
     * @Description
     * @Date 9:44 2021/4/14
     * @Param [id]
     * @return com.yunkouan.riskInterceptEntry.modules.equipment.vo.BaseEquiment
     **/
    public Equipment findById(String id);

    /**
     * @Author zhouxiaoyuan
     * @Description 设置相机在首页显示
     * @Date 16:52 2021/4/14
     * @Param [id]
     * @return com.yunkouan.riskInterceptEntry.entity.Equipment
     **/
    public OperateResult setCameraFirstPageShowByIds(String[] ids);


    /**
     * @Author zhouxiaoyuan
     * @Description 返回相机在首页得4条记录
     * @Date 9:06 2021/4/15
     * @Param []
     * @return java.util.List<com.yunkouan.riskInterceptEntry.entity.Equipment>
     **/
    public List<Equipment> findCameraFirstPageShow();

    /**
     * @Author zhouxiaoyuan
     * @Description 获取相机分组
     * @Date 11:40 2021/4/15
     * @Param []
     * @return java.util.List<com.yunkouan.riskInterceptEntry.entity.Equipment>
     **/
    public List<Equipment> findCameraGroup();

    /**
     * @Author zhouxiaoyuan
     * @Description 根据父级id找到所有的子级
     * @Date 9:40 2021/4/14
     * @Param [id]
     * @return com.yunkouan.riskInterceptEntry.modules.equipment.vo.BaseEquiment
     **/
    public List<Equipment> findByParent(String id);
    
    /**
     * @Author zhouxiaoyuan
     * @Description 最底层的条件查询
     * @Date 9:43 2021/4/14
     * @Param [baseEquiment]
     * @return java.util.List<com.yunkouan.riskInterceptEntry.modules.equipment.vo.BaseEquiment>
     **/
    public List<Equipment> findByCondition(String parentId,String type,String name ,String start, String count,String extConditon);


    /**
     * @Author zhouxiaoyuan
     * @Description 修改状态
     * @Date 17:23 2021/4/19
     * @Param [id, status]
     * @return void
     **/
    public void updateEquipmentStatus(String id,String status);

    /**
     * @Author zhouxiaoyuan
     * @Description 删除状态
     * @Date 16:41 2021/4/14
     **/
    public enum DELETE_STATUS{
        EXIST("0"),
        DELETED("1");
        String value;
        DELETE_STATUS(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * @Author zhouxiaoyuan
     * @Description 节点类型，虚拟和实体
     * @Date 16:41 2021/4/14
     **/
    public enum NODE_TYPE{
        VIRTUAL("0"),
        ENTITY("1");
        String value;
        NODE_TYPE(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    /**
     * @Author zhouxiaoyuan
     * @Description 相机是否首页显示
     * @Date 16:47 2021/4/14
     **/
    public enum CAMERA_FIRST_SHOW{
        HIDE("0"),
        SHOW("1");
        String value;
        CAMERA_FIRST_SHOW(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * @Author zhouxiaoyuan
     * @Description 类型
     * @Date 17:38 2021/4/14
     **/
    public enum EQUIPMENT_TYPE{
        CAMERA("1"),
        SERVER("2");
        String value;
        EQUIPMENT_TYPE(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }


    public enum STATUS_CONNECT_STATUS{
        PING_SUCCESS("连接正常"),
        PING_FAIL("网络断开");
        String value;
        STATUS_CONNECT_STATUS(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }


}
