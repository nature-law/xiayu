package com.naturelaw.xiayu.designpattern.behavioral.memento;

/**
 * description:  备忘录模式在实际应用中很少被使用， 运行的的动态状态可以使用创建型模式中的原型模式， 进行克隆复制对应的属性，
 * 备忘录的具体作用可能更多的像撤销操作这一类的内容， 可以使用备忘录模式。
 *
 * 发起者： 是实际客户端需要记录的具体内容， 所以发起者中的所有属性， 或者重要属性，应该复制一份到Memento 中备份， 同时发起者应该负责创建备忘录和恢复状态的行为；
 * 备忘录： 备忘录中的只是一个具有 发起者 备份属性的bean
 * 管理者： 只需要负责保存备忘录， 可以用一个List 保存多个备份
 *
 *
 * @author Administrator
 * @date 2021/5/25 17:11
 */
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setAge(18);
		originator.setName("whx");
		originator.setStatus('A');

		Memento memento = originator.createMemento();

		CareTaker careTaker = new CareTaker();
		careTaker.setMemento(memento);

		System.out.println(String.format("改变前的信息是： %s, %s, %s", originator.getAge(), originator.getName(), originator.getStatus()));
		originator.setStatus('C');
		originator.setName("whx1");
		originator.setAge(25);
		System.out.println(String.format("改变后的信息是： %s, %s, %s", originator.getAge(), originator.getName(), originator.getStatus()));
		originator.setMemento(careTaker.getMemento());
		System.out.println(String.format("恢复到改变前的信息是： %s, %s, %s", originator.getAge(), originator.getName(), originator.getStatus()));
	}
}
