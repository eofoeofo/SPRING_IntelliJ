package com.koreait.spring.fav;

import com.koreait.spring.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavService {

    @Autowired
    private FavMapper mapper;

    @Autowired
    private MyUtils myUtils;

    public int insFav(FavDomain param) {
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.insFav(param);
    }

    public int selFav(FavDomain param) {
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.selFav(param);
    }

    public int delFav(FavDomain param) {
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.delFav(param);
    }

}
