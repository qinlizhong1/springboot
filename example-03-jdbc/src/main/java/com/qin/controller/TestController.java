package com.qin.controller;

import com.qin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/meta")
    public String getMeteData() throws SQLException {
        //获取元数据信息
        DataSource dataSource = jdbcTemplate.getDataSource();
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        System.out.println("url---->" + metaData.getURL());
        System.out.println("userName---->" + metaData.getUserName());
        System.out.println("driverName---->" + metaData.getDriverName());
        System.out.println("driverVersion---->" + metaData.getDriverVersion());

        return "ok";
    }

    @RequestMapping("/add")
    public String addUser(){
        User user = new User();
        user.setId(17);
        user.setUserName("黄飞鸿");
        user.setPassWord("121212");
        user.setPhone("168686868");

        String sql="insert into user(id, username, password, phone) values(?,?,?,?) ";
        int res = jdbcTemplate.update(sql, user.getId(), user.getUserName(), user.getPassWord(),
                user.getPhone());

        if (1 == res){
            return "插入成功";
        }
        return "插入失败";
    }

    @RequestMapping("/update")
    public String uodateUser(){
        //1.sql语句
        String sql="update user set username=?, password=? where id=?  ";

        int res = jdbcTemplate.update(sql, "黄飞鸿_改名", 111111, 17);

        if (1 == res){
            return "更新成功";
        }
        return "更新失败";
    }

    @RequestMapping("/find")
    public List<User> findAllUser(){
        String sql = "select * from user";

        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setPhone(rs.getString("phone"));

                return user;
            }
        });

        return userList;
    }

    @RequestMapping("/del")
    public String deleteUser(){
        String sql = "delete from user where id = ?";

        int res = jdbcTemplate.update(sql, 17);

        if (1 == res){
            return "删除成功";
        }
        return "删除失败";
    }
}
