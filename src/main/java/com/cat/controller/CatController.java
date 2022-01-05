package com.cat.controller;

import com.cat.response.CommonReturnType;
import com.cat.controller.viewobject.CatVO;
import com.cat.error.BusinessException;
import com.cat.error.EmBusinessError;
import com.cat.service.CatService;
import com.cat.service.model.CatModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller("cat")
@RequestMapping("/cat")
public class CatController extends BaseController {

    @Autowired
    private CatService catService;


    @GetMapping("/get")
    @ResponseBody
    public CommonReturnType getCat(@RequestParam(name = "id")String id) throws BusinessException {
        CatModel catModel = catService.getCatById(id);

        if (catModel == null){
            throw new BusinessException(EmBusinessError.CAT_NOT_EXIST);
        }

        CatVO catVO = convertFromModel(catModel);

        return CommonReturnType.create(catVO);
    }

    //API pour trouver le chat le plus populaire
    @GetMapping("/getMostPopularCat")
    @ResponseBody
    public CommonReturnType getMostPopularCat() throws BusinessException {
        CatModel mostPopularCat = catService.getMostPopularCat();

        if (mostPopularCat == null){
            throw new BusinessException(EmBusinessError.CAT_NOT_EXIST);
        }

        CatVO catVO = convertFromModel(mostPopularCat);

        return CommonReturnType.create(catVO);
    }


    //2.API pour voir tous les chats avec leur score
    @GetMapping("/getAll")
    @ResponseBody
    public CommonReturnType getCat() throws BusinessException {
        List<CatModel> allCat = catService.getAllCat();

        //Use the stream api to convert the catModel inside the list into a catVO;
        List<CatVO> list_catVO = allCat.stream().map(catModel -> {
            CatVO catVO = this.convertFromModel(catModel);
            return catVO;
        }).collect(Collectors.toList());

        return CommonReturnType.create(list_catVO);
    }

    //API pour voter
    @PostMapping("/vote")
    @ResponseBody
    public CommonReturnType voteCat(@RequestParam(name = "id")String id) throws BusinessException{


        boolean b = catService.voteCat(id);
        if (!b){
            throw new BusinessException(EmBusinessError.VOTE_CAT_FAILED);
        }

        return CommonReturnType.create(null);
    }



    private CatVO convertFromModel(CatModel catModel){
        if (catModel == null){
            return null;
        }
        CatVO catVO = new CatVO();
        BeanUtils.copyProperties(catModel,catVO);
        return catVO;
    }




}
