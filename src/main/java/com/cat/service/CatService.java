package com.cat.service;

import com.cat.dao.CatDOMapper;
import com.cat.dataobject.CatDO;
import com.cat.service.impl.CatServiceImpl;
import com.cat.service.model.CatModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService implements CatServiceImpl {

    @Autowired
    private CatDOMapper catDOMapper;

    @Override
    public CatModel getCatById(String id) {
        CatDO catDO = catDOMapper.selectByPrimaryKey(id);
        if (catDO == null){
            return null;
        }
        return convertFromDataObject(catDO);
    }

    @Override
    public CatModel getMostPopularCat() {
        CatDO mostPopularCat = catDOMapper.getMostPopularCat();
        if (mostPopularCat == null){
            return null;
        }
        return convertFromDataObject(mostPopularCat);
    }

    @Override
    public List<CatModel> getAllCat() {
        List<CatDO> allCats = catDOMapper.findAllCats();

        List<CatModel> catModels = allCats.stream().map(catDO -> {
            CatModel catModel = this.convertFromDataObject(catDO);
            return catModel;
        }).collect(Collectors.toList());

        return catModels;
    }

    @Override
    public boolean voteCat(String id) {
        int i = catDOMapper.voteCat(id);
        if (i > 0){
            //vote success
            return true;
        }else {
            return false;
        }
    }

    private CatModel convertFromDataObject(CatDO catDO){
        if (catDO == null){
            return null;
        }

        CatModel catModel = new CatModel();
        BeanUtils.copyProperties(catDO,catModel);

        return catModel;
    }

}
