package com.cxzcanying.winterproject.mapper;

import com.cxzcanying.winterproject.entity.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 21311
 */
@Mapper
public interface OperationLogMapper {
    @Insert("INSERT INTO operation_logs (operation_name, start_time, end_time, duration) " +
            "VALUES (#{operationName}, #{startTime}, #{endTime}, #{duration})")
    void insertOperationLog(OperationLog operationLog);

    @Select("SELECT * FROM operation_logs")
    List<OperationLog> getAllOperationLog();
} 