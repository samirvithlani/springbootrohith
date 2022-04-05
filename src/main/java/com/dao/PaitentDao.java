package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.PaitentBean;

@Repository
public class PaitentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addPaitent(PaitentBean paitentBean) {

		return jdbcTemplate.update("insert into paitent(paname,page,did)values(?,?,?)", paitentBean.getpName(),
				paitentBean.getpAge(), paitentBean.getdId());
	}

	private final static class PaitentMapper implements RowMapper<PaitentBean> {

		@Override
		public PaitentBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			PaitentBean paitentBean = new PaitentBean();
			paitentBean.setpName(rs.getString("paname"));
			paitentBean.setpAge(rs.getInt("page"));
			paitentBean.setdName(rs.getString("dname"));
			paitentBean.setdExp(rs.getInt("dexp"));
			paitentBean.setpId(rs.getInt("pid"));
			paitentBean.setdAge(rs.getInt("dage"));
			paitentBean.setdId(rs.getInt("did"));
			paitentBean.setdEmail(rs.getString("demail"));
			return paitentBean;
		}

	}

	public List<PaitentBean> getallPaitents() {

		return jdbcTemplate.query("select * from paitent natural join doctor", new PaitentMapper());
	}

	public PaitentBean getPaitentById(int dId) {

		return jdbcTemplate.queryForObject("select * from paitent natural join doctor where did=" + dId + "", new PaitentMapper());
	}

}
