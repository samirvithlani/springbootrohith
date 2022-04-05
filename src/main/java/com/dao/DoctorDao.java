package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.DoctorBean;

@Repository
public class DoctorDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addDoctor(DoctorBean doctorBean) {

		return jdbcTemplate.update("insert into doctor(dname,demail,dage,dexp)values(?,?,?,?)", doctorBean.getdName(),
				doctorBean.getdEmail(), doctorBean.getdAge(), doctorBean.getdExp());
	}

	private final static class DoctorMapper implements RowMapper<DoctorBean> {

		@Override
		public DoctorBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DoctorBean doctorBean = new DoctorBean();
			doctorBean.setdId(rs.getInt("did"));
			doctorBean.setdName(rs.getString("dname"));
			doctorBean.setdExp(rs.getInt("dexp"));
			doctorBean.setdAge(rs.getInt("dage"));
			doctorBean.setdEmail(rs.getString("demail"));
			return doctorBean;
		}

	}

	public List<DoctorBean> getAllDoctors() {

		return jdbcTemplate.query("select * from doctor", new DoctorMapper());
	}

	public DoctorBean getdoctorbyId(int dId) {

		return jdbcTemplate.queryForObject("select * from doctor where did = " + dId + "", new DoctorMapper());
	}

	public int deleteDoctor(int dId) {

		return jdbcTemplate.update("delete from doctor where did = ?", dId);
	}

	public int updateDoctor(int dId, DoctorBean doctorBean) {

		return jdbcTemplate.update("update doctor set dname = ?,demail = ?,dage=?,dexp = ? where did = ?",
				doctorBean.getdName(), doctorBean.getdEmail(), doctorBean.getdAge(), doctorBean.getdExp(), dId);
	}

}
