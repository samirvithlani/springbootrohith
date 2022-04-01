package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BugBean;
import com.dao.BugDao;

@RestController
public class BugController {

	@Autowired
	BugDao bugDao;

	@PostMapping(value = "/addbug")
	public BugBean addBug(BugBean bugBean) {

		int res = bugDao.addBug(bugBean);

		return bugBean;
	}

	@GetMapping("/getallbug")
	public List<BugBean> getAllBugs() {

		return bugDao.getAllBugs();
	}

//	@PostMapping(value = "/addbug")
//	public BugBean addBug(@RequestParam("bname") String bugname, @RequestParam("btime") int btime,
//			@RequestParam("bdesc") String bDesc) {
//
//		BugBean bean = new BugBean();
//		bean.setbName(bugname);
//		bean.setbTime(btime);
//		bean.setbDescription(bDesc);
//		
//		//dao
//
//		return null;
//	}
}
