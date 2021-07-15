package com.naturelaw.sysutils.utils;

import com.naturelaw.sysutils.http.OkHttpSingleClient;
import org.slf4j.Logger;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/7/13 10:27
 */
public class IdUtils {
	private static final Logger LOGGER = getLogger(IdUtils.class);

	private static final String ID_GEN_BASE_URL = "http://8.142.78.63:10005";
	private static final String PATH = "/api/snowflake/get/leaf-segment-id";

	public static long genId() {
		long id = -1L;
		OkHttpSingleClient client = OkHttpSingleClient.getInstance();
		try {
			String idStr = client.get(ID_GEN_BASE_URL + PATH);
			id = Long.parseLong(idStr);
		} catch (IOException e) {
			LOGGER.error("生成ID时，网络请求失败！{}", e.getMessage(), e);
		}
		return id;
	}

}
