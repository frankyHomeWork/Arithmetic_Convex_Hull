# 演算法作業
## 可直接運行的jar
在根資料夾下 `HW2-1.0-SNAPSHOT.jar`
![image](./gif/demo.gif)

## 主要程式位置
* main函式進入點 => `./src/main/java/franky/demo/HW2.java`
* 演算法物件 =>  `./src/main/java/franky/demo/ConvexHullArithmetic.java`

## 編譯環境與指令
### 環境 
* java => 1.8.0_231
* javac => 1.8.0_211
### 編譯指令
1. `mkdir out`
2. `javac -encoding utf-8 -d .\\out .\\src\\main\\java\\franky\\demo\\*.java`
### 執行指令
1. `java -cp .\\out franky.demo.HW2`
## 建置環境
### 利用Maven打包
`mvn package` 在target資料夾下會看到 可執行jar，`HW2-1.0-SNAPSHOT.jar`

