package com.cat.service.impl;


import com.cat.service.model.CatModel;


import java.util.List;

public interface CatServiceImpl {
    CatModel getCatById(String id);

    CatModel getMostPopularCat();

    List<CatModel> getAllCat();

    boolean voteCat(String id);
}
