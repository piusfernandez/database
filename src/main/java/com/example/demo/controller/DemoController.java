package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	@Qualifier("postgresJdbcTemplate")
	private JdbcTemplate postgresTemplate;

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlTemplate;

	/**
	 * end point to get post gres cities data
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getPGUser")
	public String getPGUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		String query = " select * from cities limit 1";
		try {
			map = postgresTemplate.queryForMap(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PostgreSQL Data: " + map.toString();
	}

	/**
	 * end point to get mysql cities data
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMYUser")
	public String getMYUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		String query = " select * from city limit 1";
		try {
			map = mysqlTemplate.queryForMap(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "MySQL Data:" + map.toString();
	}
}