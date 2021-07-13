package com.naturelaw.auth.controller;

import com.naturelaw.sysutils.utils.IdUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author Administrator
 * @date 2021/7/13 11:25
 */
@RestController
@RequestMapping("/ids")
public class IdGenController {
	@GetMapping(value = "/id")
	public long genId() {
		return IdUtils.genId();
	}
}
