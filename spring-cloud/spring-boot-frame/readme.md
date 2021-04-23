

1. fastDFS 按照文档配置即可
2. nginx 配置
location ~ /group([0-9])/M00 {
		#add_header Content-Disposition "attachment;filename=$arg_attname"; 如果解开，图片就会直接下载
		ngx_fastdfs_module;
	}