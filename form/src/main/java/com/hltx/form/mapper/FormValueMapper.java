package com.hltx.form.mapper;

import com.hltx.beans.FormValue;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/13
 * Time: 12:52
 * Description:
 */
public interface FormValueMapper {

    int addvalue(@Param("formValue") FormValue formValue);

    List<FormValue> getFormvalueBymodelID(@Param("mid")String mid,@Param("index") Integer index,@Param("pagesize")Integer pagesize);

    List<FormValue> getFormvalueByuserID(@Param("uid") Integer uid,@Param("index") Integer index,@Param("pagesize") Integer pagesize);

    FormValue getByid(@Param("id") String id);

    int getCountByPhoneAndMoel(@Param("phone") String phone ,@Param("mid") String mid);
}
