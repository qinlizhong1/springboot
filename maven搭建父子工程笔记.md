### maven搭建springBoot父子工程
1.创建springboot父工程，删掉src文件夹；pom.xml中要设置工程的打包方式为pom
  
2.以module形式创建springboot子工程
3.




### 将本地仓库推送并关联到远端仓库
0.创建springboot本地仓库,在springboot目录下执行：
               git init
1.github上创建远端仓库，如：git@github.com:qinlizhong1/springboot.git
2.将修改过的文件通过如下命令提交到本地仓库：
               git add 修改的文件名 
               git commit -m "修改说明"
  
3.推送push
               git remote add origin git@github.com:qinlizhong1/springboot.git
               git push -u origin master
 需要注意的是：Github上的默认分支为main，本地创建的git分支默认为master,不统一，可以
            通过https://github.com/settings/repositories设置成习惯的master：
   