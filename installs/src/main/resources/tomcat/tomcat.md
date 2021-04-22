
部署方式:
第一种：
非常简单，直接将 web 项目文件（一般是复制生成的war包）复制到tomcat的webapps目录中。

第二种：
在本地tomcat的conf目录中，新建Catalina/localhost目录（这里要注意文件名的大小写），然后在该目录下新建一个xml文件，名字不可以随意取，要和path后 的名字一致，我这里就应该是jstore.xml文件，它的具体内容为：
<Context docBase="C:\work\jstore\web" path="/jstore" reloadable="true"/>

第三种:
在tomcat中的conf目录下的server.xml文件中，在<Host/>节点中添加一个context，具体为：
<Context Path="/jstore"Docbase="C:\work\jstore\WebContent" Debug="0" Privileged="True" Reloadable="True"></


