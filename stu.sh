#!/bin/bash

APP_NAME="stu"
VERSION="1.0"
PORT="80"

# 停止旧版本容器
echo "正在停止旧版本容器..."
docker stop ${APP_NAME}
# 清理旧版本容器
echo "正在清理旧版本容器..."
docker rm ${APP_NAME}
# 清理旧版本镜像
echo "正在清理旧版本镜像..."
docker rmi registry.cn-shanghai.aliyuncs.com/ilme/${APP_NAME}:1.0
# 拉取新镜像并启动容器
echo "拉取新镜像..."
docker run -d -p ${PORT}:8080 --name ${APP_NAME} registry.cn-shanghai.aliyuncs.com/ilme/${APP_NAME}:${VERSION}
echo "==================="
echo "== START SUCCESS >>"
echo "==================="
echo ""
echo "View the logs using the command 'docker logs -f ${APP_NAME}'"
echo ""
# 查看日志
# docker logs -f ${APP_NAME} &
