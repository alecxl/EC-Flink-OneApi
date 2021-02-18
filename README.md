# EC-Flink-OneApi
# 基于Flink的流批一体电商项目实践

## 环境准备
    项目硬件环境目前为一台虚拟机，配置为10G运行内存8线程
    运行环境使用docker搭建，目前Dockerfile在搭建过程中可能会有些问题，还没有修改，如果有需要可以联系我，后面考虑将镜像上传到hub

## 数据准备

    日志数据与业务数据均为模拟数据

## 文件说明
    EC-logger  spring boot 项目接受模拟数据将数据直接写入到kafka中
    dataload-jar 数据导入的文件jar包
    dataload-sh  数据导入的脚本文件
    
## 更新日志:
    - 2021-02-18 
        - 基本环境搭建
        - 日志数据模拟
        - 日志数据写入到kafka中
        
        
## 参考文章
    1. [数据仓库、数据湖、流批一体](https://zhuanlan.zhihu.com/p/141182199?from_voters_page=true)
    2. [基于 Flink + Hive 构建流批一体准实时数仓](https://www.jianshu.com/p/4e728a8993ea)
