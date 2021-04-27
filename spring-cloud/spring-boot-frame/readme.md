
> 组件: 
```
fastDFS 文件上传管理
springboot  
mybitis-plus  orm框架
nginx  反向代理，负载均衡
```


1. fastDFS 按照文档配置即可
nginx 配置
location ~ /group([0-9])/M00 {
		#add_header Content-Disposition "attachment;filename=$arg_attname"; 如果解开，图片就会直接下载
		ngx_fastdfs_module;
	}
	
2. mybatis https://baomidou.com/

3. 启用服务 fastDFS服务
systemctl enable fdfs_trackerd
systemctl enable fdfs_storaged
systemctl enable nginx

4. 文件
查看 使用nginx
http://172.16.17.53/equipment/down?group=group1&filePath=M00/00/00/rBARNWCGbzGAesSVAAFW-2DQsPw610.jpg&fileName=xxx.jpg
下载
172.16.17.39:8888/equipment/down?group=group1&filePath=M00/00/00/rBARNWCGcd2AEkUAAAEPSycAdKM931.jpg&fileName=xxx00.jpg

