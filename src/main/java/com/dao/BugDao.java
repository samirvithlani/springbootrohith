package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.BugBean;

@Repository
public class BugDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static class BugMapper implements RowMapper<BugBean> {

		@Override
		public BugBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			BugBean bean = new BugBean();
			bean.setbId(rs.getInt("bid"));
			bean.setbName(rs.getString("bname"));
			bean.setbDescription(rs.getString("bdesc"));
			bean.setbTime(rs.getInt("btime"));

			return bean;
		}

	}

	public List<BugBean> getAllBugs() {

		return jdbcTemplate.query("select * from bug", new BugMapper());
	}

	public int addBug(BugBean bugBean) {

		return jdbcTemplate.update("insert into bug(bname,bdesc,btime)values(?,?,?)", bugBean.getbName(),
				bugBean.getbDescription(), bugBean.getbTime());
	}

	public int deleteBug(int bId) {

		return jdbcTemplate.update("delete from bug where bid = ?", bId);
	}

}
