package com.naturelaw.system.http;

/**
 * description: http result
 *
 * @author Administrator
 * @date 2021/7/9 13:28
 */
public class Result<T> {
	/**
	 * 状态码
	 **/
	private int code;
	/**
	 * 返回信息
	 **/
	private String message;
	/**
	 * 返回数据
	 **/
	private T data;


}
