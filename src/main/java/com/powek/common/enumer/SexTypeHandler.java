package com.powek.common.enumer;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler implements TypeHandler<SexType> {

    public void setParameter(PreparedStatement preparedStatement, int i, SexType sexType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexType.getType());
    }

    public SexType getResult(ResultSet resultSet, String s) throws SQLException {
        Integer type = resultSet.getInt(s);
        return SexType.getByType(type);
    }

    public SexType getResult(ResultSet resultSet, int i) throws SQLException {
        Integer type = resultSet.getInt(i);
        return SexType.getByType(type);
    }

    public SexType getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer type = callableStatement.getInt(i);
        return SexType.getByType(type);
    }
}
