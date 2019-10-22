package com.example.demo02.service.impl;

import com.example.demo02.bean.Dic;
import com.example.demo02.dao.DicRepository;
import com.example.demo02.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DicServiceImpl implements DicService {
    @Autowired
    DicRepository dicDao;

    @Override
    public Integer addDic(Dic dic) {
        Dic save = dicDao.save(dic);
        int id = save.getId();
        save.setDicname(1 + save.getDicname());
        dicDao.save(save);
        return id;
    }
}
