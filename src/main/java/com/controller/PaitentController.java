package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PaitentBean;
import com.dao.PaitentDao;

@RestController
public class PaitentController {

	@Autowired
	PaitentDao paitentDao;

	@PostMapping(value = "/addpaitent")
	public ResponseEntity<PaitentBean> addPaitent(@RequestBody PaitentBean paitentBean) {

		int res = paitentDao.addPaitent(paitentBean);
		if (res > 0) {

			return new ResponseEntity<PaitentBean>(paitentBean, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

	@GetMapping("/getallpaitents")
	public ResponseEntity<List<PaitentBean>> getallpaitents(){
		
		List<PaitentBean> paitentlist = paitentDao.getallPaitents();
		if(paitentlist.size()>0) {
			
			return new ResponseEntity<List<PaitentBean>>(paitentlist, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@GetMapping(value = "/getpaitent/{id}")
	public ResponseEntity<PaitentBean> getPaitnetByDid(@PathVariable("id") int dId){
		
		PaitentBean paitentBean = paitentDao.getPaitentById(dId);
		if(paitentBean!=null) {
			
			return new ResponseEntity<PaitentBean>(paitentBean, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
	}
	
}
