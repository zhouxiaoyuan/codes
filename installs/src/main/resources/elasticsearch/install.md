

docker run -itd --name es -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.12.0 -e "ES_JAVA_OPTS=-Xms64m -Xmx64m"
 
es
could not find java in bundled JDK at  增加权限
结点不可用，kibana无法启动
master not discovered yet      cluster.initial_master_nodes: ["127.0.0.1:9300"]

es增加跨域访问
http.cors.enabled: true
http.cors.allow-origin: "*"

搜索:
1. 高效的压缩算法
2. 快速的编解码

查询速度
召回率
BM25
PM

elasticsearch 9200
kibana 5601
head插件   9100

B-Trees 多路平衡查找树
以数据结构为载体
以文件存储

luence  
buffer  refresh
segment   -> 才能查到



