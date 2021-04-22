


整体思路:
1. 安装nginx, 使用淘宝tengine ,安装步骤参考以下
2. 配置nginx, 
upstream 方向代理
~ .*\.(js|css|jpg|png)$ 静态资源
达到动静分离

多tomcat共享session


configure --prefix=/bigdata/tengine
make & make install

###### 安装服务
vim /lib/systemd/system/nginx.service 

启动nginx服务
systemctl start nginx.service
设置开机自启动
systemctl enable nginx.service
停止开机自启动
systemctl disable nginx.service
查看服务当前状态
systemctl status nginx.service
重新启动服务
systemctl restart nginx.service
查看所有已启动的服务
systemctl list-units --type=service

需要安装组件:
yum -y install pcre-devel
yum -y install openssl openssl-devel

错误为：./configure: error: the HTTP rewrite module requires the PCRE library.
安装pcre-devel解决问题
yum -y install pcre-devel

还有可能出现：
错误提示：./configure: error: the HTTP cache module requires md5 functions
from OpenSSL library.   You can either disable the module by using
--without-http-cache option, or install the OpenSSL library into the system,
or build the OpenSSL library statically from the source with nginx by using
--with-http_ssl_module --with-openssl=<path> options.
解决办法：
yum -y install openssl openssl-devel

启动memcached
memcached -d -m 128 -u root -l 172.16.17.53 11211 -c 256 -P /tmp/memcached.pid
memcached-tool 172.16.17.53:11211


jsp中使用session
request.getSession().getId()
直接使用session报错

nginx配置:
proxy_pass http://httpds;
proxy_set_header Host $host;

