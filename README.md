# android-support-mvp-plus
- [Take for android-architecture](https://github.com/googlesamples/android-architecture)

### 发布
- 因为依赖太多第三方库，会导致频繁更新，所以不发布到jcenter。
- 可发布到本地maven中，执行`gradlew uploadArchives`。

### 工程结构
* ./mvp
> mvp library
```
package: com.amlzq.android.architecture
```
* ./sample
> sample application
```
package: com.amlzq.asb
appName: MVP-Plus支持库
applicationId: com.amlzq.asb.mvp.plus
```

### 重点
- [Retrofit自定义GsonConverter处理所有请求错误情况](https://www.jianshu.com/p/5b8b1062866b)

### mvp-plus
- 拥抱注解式编程
- 拥抱响应式编程
- 拥抱强大且知名的第三方SDK(JakeWharton/Square/GreenroBot)

- 基础SDK
```
google support
amlzq support
```
- 第三方SDK
```
OkHttp3
Retrofit2
GreenDao
EventBus
ButterKnife
Dagger2
```
- 响应式编程
```
RxJava
RxAndroid
RxBinding
RxPermissions
RxBus
```
- 注解式编程
```
Dagger2
Retrofit2
EventBus
ButterKnife
```

- RxJava&RxAndroid
```
ActionN 和 FuncN 遵循Java 8的命名规则。
其中，Action0 改名成Action，Action1改名成Consumer，而Action2改名成了BiConsumer，而Action3 - Action9都不再使用了，ActionN变成了Consumer<Object[]>。
同样，Func改名成Function，Func2改名成BiFunction，Func3 - Func9 改名成 Function3 - Function9，FuncN 由 Function<Object[], R> 取代。
```
```
RxAndroid非常简单，增加了Android线程调度。
```
- [RxJava1 升级到 RxJava2 所踩过的坑](https://www.jianshu.com/p/6d644ca1678f)
- [Android响应式编程框架---RxJava&RxAndroid2.0使用笔记](https://blog.csdn.net/DeMonliuhui/article/details/77848691)
- [关于RxJava背压](http://flyou.ren/2017/04/05/%E5%85%B3%E4%BA%8ERxJava%E8%83%8C%E5%8E%8B/?utm_source=tuicool&utm_medium=referral)
- [在RxJava2里面，对于网络请求应该用Single、Observable还是Flowable？](https://www.zhihu.com/question/62300736)
- []()

- ButterKnife利弊
```
原理：
1.ButterKnife首先会在编译期间利用Java Annotation Processin生成一个XXX_ViewBinding的类。
2.ButterKnife.bind中通过反射实例化XX_ViewBinding，完成View的各项绑定，实现方式就是普通的findviewbyid等。
3.unbinder.unbind方法是一些置空操作，便于垃圾回收器回收内存。
缺点：
1.所以会是文件，同时注意混淆。
2.反射效率低。
优点：
1.快速编程。
实践：
1.尽量不用，或者用kotlin取代
```

- 事件总线问题 RxBus
```

```
- [使用RxJava实现事件总线 - RxBus](https://blog.kaush.co/2014/12/24/implementing-an-event-bus-with-rxjava-rxbus/)
- [放弃RxBus，拥抱RxJava（一）：为什么避免使用EventBus/RxBus](https://www.jianshu.com/p/61631134498e)
- [放弃RxBus，拥抱RxJava（二）：Observable究竟如何封装数据？](https://www.jianshu.com/p/d2df6bceeff9)
- [RxBus在rxjava2.0 的基本使用](https://blog.csdn.net/donkor_/article/details/79709366)
- [RxBus真的能替代EventBus吗？](https://www.jianshu.com/p/669eda5dc5a4)
- [Android消息总线的演进之路：用LiveDataBus替代RxBus、EventBus](https://tech.meituan.com/2018/07/26/android-livedatabus.html)

- RxBinding
```
基于RxJava的事件流
ButterKnife注入控件, RxBinding异步监听事件
```
- [手把手教你写RxBinding](https://www.jianshu.com/p/055002aaf1ca)
- [Android实战——RxJava2+Retrofit+RxBinding解锁各种新姿势](https://blog.csdn.net/qq_30379689/article/details/68958173)

- google arch room
```
修改为GreenDao
```
- [7 Steps To Room](https://medium.com/androiddevelopers/7-steps-to-room-27a5fe5f99b2)
- [数据库ROOM-Google新推](https://www.jianshu.com/p/bb8bd5bc8304)

- [greenDao](http://greenrobot.org/greendao/)
```
场景：
小型，数据量不大，操作不频繁的
优点

缺点

```
- [更新到greenDAO 3和注释](http://greenrobot.org/greendao/documentation/updating-to-greendao-3-and-annotations/)
- [Android ORM 框架：GreenDao 使用详解（基础篇）](https://juejin.im/post/5959b5bcf265da6c4d1bb245)
- [greenDao使用进阶](https://segmentfault.com/a/1190000009076317)
- [Android数据库框架 greenDAO：3.2.0的使用](https://www.jianshu.com/p/cc7c1ecdfacf)

### OkHttp/Retrofit
- [重拾Android之路之探究Retrofit 2.X](https://www.jianshu.com/p/5c0c546fc540)
- [Content-Type](https://blog.csdn.net/bigtree_3721/article/details/82809459)

- [RxJava的Single、Completable以及Maybe](https://www.jianshu.com/p/45309538ad94)
- [在RxJava2里面，对于网络请求应该用Single、Observable还是Flowable？](https://www.zhihu.com/question/62300736)
- [RxJava全局Error处理](https://blog.csdn.net/mq2553299/article/details/82823565)

### 其他优秀的框架
- [todo-mvp-rxjava](https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava)
- [MVPArms](https://github.com/JessYanCoding/MVPArms)
- [MVP项目实践](https://juejin.im/entry/57d22b79a22b9d006c4720ee)
