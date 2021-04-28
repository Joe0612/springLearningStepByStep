package com.yc.springboot.helloworld.tx.Dao;

import com.yc.springboot.helloworld.tx.bean.OpRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-17 14:17
 */
@Repository
public class OpRecordDaoImpl implements OpRecordDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }


    @Override
    public void saveOpRecord(OpRecord opRecord) {
        String sql="insert into oprecord(accountid,opmoney,optime,optype,transferid) values(?,?,?,?,?)";

        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt=connection.prepareStatement(sql,new String[]{"id"});
            pstmt.setInt(1,opRecord.getAccountID());
            pstmt.setDouble(2,opRecord.getOpmoney());
            pstmt.setTimestamp(3,opRecord.getOptime());
            pstmt.setString(4,opRecord.getOptype());
            pstmt.setString(5,opRecord.getTransferid());
            return pstmt;
        },keyHolder);
    }

    @Override
    public List<OpRecord> findAll() {
        String sql="select * from oprecord";
        List<OpRecord> list=this.jdbcTemplate.query(sql, (resultSet,rowNum)->{
           OpRecord o=new OpRecord();
           o.setId(resultSet.getInt("id"));
           o.setAccountID(resultSet.getInt("accountid"));
           o.setOpmoney(resultSet.getDouble("opmoney"));
           o.setOptime(resultSet.getTimestamp("optime"));
           o.setOptype(resultSet.getString("optype"));
           o.setTransferid(resultSet.getString("transferid"));
           return o;
        });
        return list;
    }

    @Override
    public List<OpRecord> findByAccountid(int accountID) {
        String sql="select * from oprecord where accountid=? ";
        List<OpRecord> list=this.jdbcTemplate.query(sql, (resultSet ,rowNum )->{
            OpRecord o=new OpRecord();
            o.setId(resultSet.getInt("id"));
            o.setAccountID(resultSet.getInt("accountid"));
            o.setOpmoney(resultSet.getDouble("opmoney"));
            o.setOptime(resultSet.getTimestamp("optime"));
            o.setOptype(resultSet.getString("optype"));
            o.setTransferid(resultSet.getString("transferid"));
            return o;
        },accountID);
        return list;
    }
}
