docker search elasticsearch
docker pull elasticsearch:7.9.1
初始堆内存大小256M:-Xms256m，最大使用堆内存大小:-Xmx256m
docker run -d -e "discovery.type=sin``gle-node" -e ES_JAVA_OPTS="-Xms256m -Xmx512m" -p 29200:9200 -p 29300:9300 --name myEs01 f29a1ee41030