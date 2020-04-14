### YRestartApp 使用

- 依赖
   ```groovy
    implementation 'com.yey.library_restartapp:library_restartapp:0.0.3'
   ```
- 使用
    ```java
    // 100 是关闭APP之后100毫秒后再启动APP
    YRestartAPP.restartAPP(MainActivity.this,100);
    ```
