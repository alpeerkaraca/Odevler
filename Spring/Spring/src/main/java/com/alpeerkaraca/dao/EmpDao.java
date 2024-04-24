package com.alpeerkaraca.dao;

import com.alpeerkaraca.spring.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao {

    JdbcTemplate jt;

    public void setTemplate(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int saveEmp(Emp emp) {
        String sql = "insert into emp99 (empName, empSalary, empDesignation) values(" + emp.getEmpName() + "," + emp.getEmpSalary() + ","+ emp.getEmpDesignation() + ")";
        return jt.update(sql);
    }

    public int updateEmp(Emp emp) {
        String sql = "UPDATE emp99 set empName=" + emp.getEmpName() + ", empSalary=" + emp.getEmpSalary() + ", empDesignation=" + emp.getEmpDesignation() +  "where empID=" + emp.getEmpID() + "";
        return jt.update(sql);
    }

    public int deleteEmp(int empID) {
        String sql = "delete from emp99 where empID=" + empID;
        return jt.update(sql);
    }

    public Emp getEmpById(int empID) {
        String sql = "select * from emp99 where empID=" + empID;
        return jt.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
    }

    public List<Emp> getEmployees(){
        return jt.query("select * from emp99", new RowMapper<Emp>(){
            public Emp mapRow(ResultSet rs, int row) throws  SQLException {
                Emp emp = new Emp();
                emp.setEmpID(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
                emp.setEmpSalary(rs.getFloat(3));
                emp.setEmpDesignation(rs.getString(4));
                return emp;
            }
        })
    }
}
