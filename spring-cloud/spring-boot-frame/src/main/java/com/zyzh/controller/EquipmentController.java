package com.zyzh.controller;

import com.zyzh.commons.model.OperateResult;
import com.zyzh.entity.Equipment;
import com.zyzh.mapper.EquipmentMapper;
import com.zyzh.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhouxiaoyuan
 * @Description 设备
 * @Date 11:31 2021/4/14
 **/
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@PostMapping("/add")
	public OperateResult add(Equipment equipment) {
		return equipmentService.add(equipment);
	}

	@PostMapping("/update" )
	public OperateResult update( Equipment equipment) {
		return equipmentService.update(equipment);
	}

	@PostMapping("/delete" )
	public OperateResult delete(String id) {
		return equipmentService.delete(id);
	}

	@RequestMapping("/find" )
	public Equipment find(String id ) {
		return equipmentService.findById(id);
	}

	@PostMapping("/camera/fisrtPage/set" )
	public OperateResult setCameraFisrtPage(String[] ids) {
		return equipmentService.setCameraFirstPageShowByIds(ids);
	}

	@RequestMapping("/camera/fisrtPage/get" )
	public List<Equipment> getCameraFisrtPage() {
		return equipmentService.findCameraFirstPageShow();
	}

	@RequestMapping("/camera/group/list" )
	public List<Equipment>  cameraGroupList() {
		return equipmentService.findCameraGroup();
	}

	@RequestMapping("/camera/group" )
	public List<Equipment> cameraGroup(String parentid ) {
		return equipmentService.findByCondition(parentid,null,null,null,null,null);
	}

	@RequestMapping("/findPage" )
	public List<Equipment> findPage(String parentid , String type, String name , String start, String count) {
		return equipmentService.findByCondition(parentid,type,name,start,count,null);
	}

}
