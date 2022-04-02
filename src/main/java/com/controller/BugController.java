package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BugBean;
import com.dao.BugDao;

@RestController
@CrossOrigin
public class BugController {

	@Autowired
	BugDao bugDao;

//	@PostMapping(value = "/addbug")
//	public String addBug(BugBean bugBean) {
//
//		int res = bugDao.addBug(bugBean);
//
//		return "bug is added..";
//	}

	@PostMapping(value = "/addbug")
	public ResponseEntity<BugBean> addBug(@RequestBody BugBean bugBean) {

		int res = bugDao.addBug(bugBean);
		if (res > 0) {

			return new ResponseEntity<BugBean>(bugBean, HttpStatus.CREATED);
		}

		return new ResponseEntity<BugBean>(HttpStatus.CONFLICT);
	}

//	@GetMapping("/getallbug")
//	public List<BugBean> getAllBugs() {
//
//		return bugDao.getAllBugs();
//	}

	@GetMapping(value = "/getallbug")
	public ResponseEntity<List<BugBean>> getAllBugs() {

		List<BugBean> buglist = bugDao.getAllBugs();
		if (buglist.size() > 0) {

			return new ResponseEntity<List<BugBean>>(buglist, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") int id) {

		System.out.println(id);
		int res = bugDao.deleteBug(id);

		System.out.println(res);
		if (res >= 0) {

			new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<String>(HttpStatus.CONFLICT);
	}

	@DeleteMapping(value = "/delete1")
	public ResponseEntity<String> deleteData1(@RequestParam("id") int id) {

		System.out.println(id);
		int res = bugDao.deleteBug(id);

		System.out.println(res);
		if (res >= 0) {

			new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<String>(HttpStatus.CONFLICT);
	}

}
