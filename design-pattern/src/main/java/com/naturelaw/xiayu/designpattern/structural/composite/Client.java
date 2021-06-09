package com.naturelaw.xiayu.designpattern.structural.composite;

/**
 * description: 组合模式主要是为了处理， 具有一定的层级结构的问题， 并且具体的层级结构类似为树形结构， 每一级的结构有相同的数据结构和行为
 *1、高层模块调用简单。
 * 2、节点自由增加。
 * @author Administrator
 * @date 2021/6/2 13:35
 */
public class Client {
	public static void main(String[] args) {
		Component coreDepartment = new CoreDepartment();
		Component intelDepartment = new IntelDepartment();

		Component cloudHub = new CloudHubCompany();
		Component kingdeeChina = new KingdeeChinaCompany();

		Component kingdeeIntel = new KingdeeInternationalCompany();
		kingdeeChina.add(coreDepartment);
		kingdeeChina.add(intelDepartment);

		kingdeeIntel.add(kingdeeChina);
		kingdeeIntel.add(cloudHub);

		kingdeeIntel.doAction();

	}
}
