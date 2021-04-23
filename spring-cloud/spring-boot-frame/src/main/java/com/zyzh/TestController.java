package com.zyzh;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description com.zyzh.TestController
 * @Created by zhouxiaoyuan on 2021/4/23 15:09
 */
@Controller
public class TestController implements InitializingBean {

    @Autowired
    private FastFileStorageClient fc;

    @RequestMapping("/list")
    public String list(Model map) {
        List<City> list =  new ArrayList<>();
        list.add(new City(1,"北京"));
        list.add(new City(2,"上海"));
        map.addAttribute("list", list);
        return "list";
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
    public ResponseEntity<byte[]> down(HttpServletResponse resp) {

        DownloadByteArray cb = new DownloadByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "aaa.jpg");
        byte[] bs = fc.downloadFile("group1", "M00/00/00/rBARNWCCmz2AL-WuAAzodXNDJVY679.jpg", cb);

        return new ResponseEntity<>(bs,headers, HttpStatus.OK);
    }





    private String getFileExtName(String name) {
        // TODO Auto-generated method stub
        return (name.substring(name.lastIndexOf(".")+1));
    }




    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(fc);
    }
}
