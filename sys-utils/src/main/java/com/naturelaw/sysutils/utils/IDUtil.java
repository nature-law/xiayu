package com.naturelaw.sysutils.utils;

import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.exception.InitException;
import com.sankuai.inf.leaf.service.SnowflakeService;
import com.sankuai.inf.leaf.snowflake.SnowflakeIDGenImpl;
import com.sankuai.inf.leaf.snowflake.SnowflakeZookeeperHolder;

/**
 * description: 生成id
 *
 * @author Andy
 * @version 1.0
 * @date 06/27/2021 16:02
 */
public class IDUtil {

	public static final String LOCAL_IP = "127.0.0.1";
	public static final String ZK_IP = "8.142.78.63";
	public static final int ZK_PORT = 2181;

	public static final String ID = "id";
	public static void main(String[] args) {
		try {
			SnowflakeZookeeperHolder holder = new SnowflakeZookeeperHolder(LOCAL_IP, String.valueOf(ZK_PORT), ZK_IP);
			boolean init = holder.init();
			IDGen idGen = new SnowflakeIDGenImpl(ZK_IP, ZK_PORT);
			Result result = idGen.get(ID);
			SnowflakeService snowflakeService = new SnowflakeService(ZK_IP, ZK_PORT);
			Result id = snowflakeService.getId(ID);
			System.out.println(id);
		} catch (InitException e) {
			e.printStackTrace();
		}
	}
}
