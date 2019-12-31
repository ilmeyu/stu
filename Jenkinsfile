pipeline {
   agent any

   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/ilmeyu/student-center.git'

            // 清理仓库
            sh "rm -rf /Users/ilem/.m2/repository/com/ilem"

            // 编译打包
            sh "mvn -Dmaven.test.failure.ignore=true clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
             success {
                 // 构建容器
                 sh "docker build ./ --pull=true -t registry.cn-shanghai.aliyuncs.com/ilme/stu:1.0"
                 // 登陆镜像仓库
                 sh "docker login --username=ilmeyu --password 96upo869 registry.cn-shanghai.aliyuncs.com"
                 // 推送到镜像仓库
                 sh "docker push registry.cn-shanghai.aliyuncs.com/ilme/stu:1.0"
                 // 清除本地镜像
                 sh "docker rmi registry.cn-shanghai.aliyuncs.com/ilme/stu:1.0"
                 // 远程执行应用重启脚本
                 sh "ssh -i /Users/ilem/dev/101.133.168.248_SH003.pem root@101.133.168.248 ./stu.sh"
             }
         }

      }
   }
}