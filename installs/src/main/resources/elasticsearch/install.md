

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

倒排表 posting list ->索引文件 数据行 ,压缩: 提升查询速度，降低空间占用；存储差值，将int压缩到bit，占用int的1/32
 FOR 稠密数据，波动小  减法
 RBM 稀疏     除法，int最大2^32
词项字典 term dictionary   -> FST 字典表
词项索引 term index
倒排索引 - 分词 - 

常规索引:
1,索引会失效
2.大数据会使树深度增加，增加I/O次数，影响效率






