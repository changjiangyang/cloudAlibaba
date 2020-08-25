package com.hltx.form.service;

import com.hltx.beans.FormAssembly;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FormAssemblyService {

    List<FormAssembly> getAll();

    int addFormassembly(@Param("formAssembly") FormAssembly formAssembly);

    int deleteFormassembly(@Param("id") String id);
}
