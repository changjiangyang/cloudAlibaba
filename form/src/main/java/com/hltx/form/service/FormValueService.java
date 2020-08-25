package com.hltx.form.service;

import com.hltx.beans.FormValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormValueService {

    int addvalue(FormValue formValue);

    List<FormValue> getFormvalueBymodelID(String mid, Integer index, Integer pagesize);

    List<FormValue> getFormvalueByuserID(Integer uid,Integer index,Integer pagesize);

    FormValue getByid(String id);
    int getCountByPhoneAndMoel(@Param("phone") String phone , @Param("mid") String mid);
}
