
> 组件: 
```
fastDFS 文件管理
springboot  
mybitis-plus  orm框架
nginx  反向代理，负载均衡，高可用
```


1. fastDFS 按照文档配置即可
nginx 配置
location ~ /group([0-9])/M00 {
		#add_header Content-Disposition "attachment;filename=$arg_attname"; 如果解开，图片就会直接下载  ，可用删除，出现注释了还会直接下载得情况
		ngx_fastdfs_module;
	}
	
2. mybatis https://baomidou.com/

3. 启用服务 fastDFS服务
systemctl enable fdfs_trackerd
systemctl enable fdfs_storaged
systemctl enable nginx

/etc/rc.d/init.d/

4. 文件
查看 使用nginx
http://172.16.17.53/equipment/down?group=group1&filePath=M00/00/00/rBARNWCGbzGAesSVAAFW-2DQsPw610.jpg&fileName=xxx.jpg
下载
172.16.17.39:8888/equipment/down?group=group1&filePath=M00/00/00/rBARNWCGcd2AEkUAAAEPSycAdKM931.jpg&fileName=xxx00.jpg

5.memecache
memcached -d -m 128 -u root -l 172.16.17.53 -p 11211 -c 256 -P /tmp/memcached.pid
memcached-tool 172.16.17.53:11211
参数解释：
	-d:后台启动服务
	-m:缓存大小
	-p：端口
	-l:IP
	-P:服务器启动后的系统进程ID，存储的文件
	-u:服务器启动是以哪个用户名作为管理用户

6.虚拟机
tengine 
    /usr/local
spring 
    /apps
fastDFS
    /bigdata
    