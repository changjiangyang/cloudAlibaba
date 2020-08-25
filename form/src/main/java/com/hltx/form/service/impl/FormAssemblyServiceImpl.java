package com.hltx.form.service.impl;

import com.hltx.beans.FormAssembly;
import com.hltx.form.mapper.FormAssemblyMapper;
import com.hltx.form.service.FormAssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ycj
 * Date: 2020/8/11
 * Time: 19:11
 * Description:
 */
@Service("formAssemblyService")
public class FormAssemblyServiceImpl implements FormAssemblyService {

    @Autowired
    private FormAssemblyMapper formAssemblyMapper;

    @Override
    public List<FormAssembly> getAll() {
        return formAssemblyMapper.getAll();
    }

    @Override
    public int addFormassembly(FormAssembly formAssembly) {
        return formAssemblyMapper.addFormassembly(formAssembly);
    }

    @Override
    public int deleteFormassembly(String id) {
        return formAssemblyMapper.deleteFormassembly(id);
    }
}
