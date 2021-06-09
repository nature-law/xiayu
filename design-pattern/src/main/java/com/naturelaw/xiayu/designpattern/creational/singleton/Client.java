package com.naturelaw.xiayu.designpattern.creational.singleton;

/**
 * description: 隐藏了具体实现，  单例模式会阻止其他对象实例化其自己的单例对象的副本，从而确保所有对象都访问唯一实例。
 * 因为类控制了实例化过程，所以类可以灵活更改实例化过程。
 * 由于在系统内存中只存在一个对象，因此可以 节约系统资源，当 需要频繁创建和销毁的对象时单例模式无疑可以提高系统的性能
 *
 *   1.外部资源：每台计算机有若干个打印机，但只能有一个PrinterSpooler，以避免两个打印作业同时输出到打印机。内部资源：大多数软件都有一个（或多个）属性文件存放系统配置，这样的系统应该有一个对象管理这些属性文件
 *     2. Windows的Task Manager（任务管理器）就是很典型的单例模式（这个很熟悉吧），想想看，是不是呢，你能打开两个windows task manager吗？ 不信你自己试试看哦~
 *     3. windows的Recycle Bin（回收站）也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
 *     4. 网站的计数器，一般也是采用单例模式实现，否则难以同步。
 *     5. 应用程序的日志应用，一般都何用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 *     6. Web应用的配置对象的读取，一般也应用单例模式，这个是由于配置文件是共享的资源。
 *     7. 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。数据库软件系统中使用数据库连接池，主要是节省打开或者关闭数据库连接所引起的效率损耗，这种效率上的损耗还是非常昂贵的，因为何用单例模式来维护，就可以大大降低这种损耗。
 *     8. 多线程的线程池的设计一般也是采用单例模式，这是由于线程池要方便对池中的线程进行控制。
 *     9. 操作系统的文件系统，也是大的单例模式实现的具体例子，一个操作系统只能有一个文件系统。
 *     10. HttpApplication 也是单位例的典型应用。熟悉ASP.Net(IIS)的整个请求生命周期的人应该知道HttpApplication也是单例模式，所有的HttpModule都共享一个HttpApplication实例.
 *
 * @author Administrator
 * @date 2021/5/19 12:38
 */
public class Client {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();

		singleton.setName("whx");
		singleton.sayName();
	}

}
