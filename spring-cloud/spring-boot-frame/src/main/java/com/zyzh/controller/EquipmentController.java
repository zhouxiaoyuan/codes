package com.zyzh.controller;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zyzh.commons.model.OperateResult;
import com.zyzh.entity.Equipment;
import com.zyzh.mapper.EquipmentMapper;
import com.zyzh.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Autowired
	private FastFileStorageClient fc;

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




	@PostMapping("/uploadFile")
	@ResponseBody
	public String test(MultipartFile filename){

		// 元数据
		Set<MetaData> metaDataSet = new HashSet<MetaData>();
		metaDataSet.add(new MetaData("Author", "yimingge"));
		metaDataSet.add(new MetaData("CreateDate", "2021-04-05"));

		try {
			StorePath uploadFile = null;
			uploadFile = fc.uploadFile(filename.getInputStream(), filename.getSize(), getFileExtName(filename.getOriginalFilename()), metaDataSet);
			return uploadFile.getFullPath();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "error";
	}

	@RequestMapping("/down")
	@ResponseBody
	public ResponseEntity<byte[]> down(String group , String filePath , String fileName,HttpServletResponse resp) {

		DownloadByteArray cb = new DownloadByteArray();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		byte[] bs = fc.downloadFile(group, filePath, cb);

		return new ResponseEntity<>(bs,headers, HttpStatus.OK);
	}

	private String getFileExtName(String name) {
		// TODO Auto-generated method stub
		return (name.substring(name.lastIndexOf(".")+1));
	}


}
