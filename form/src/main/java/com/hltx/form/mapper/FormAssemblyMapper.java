package com.hltx.form.mapper;

import com.hltx.beans.FormAssembly;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormAssemblyMapper {

    List<FormAssembly> getAll();

    int addFormassembly(@Param("formAssembly") FormAssembly formAssembly);

    int deleteFormassembly(@Param("id") String id);
}
