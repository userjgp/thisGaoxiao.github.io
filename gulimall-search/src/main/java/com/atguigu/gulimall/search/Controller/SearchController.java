package com.atguigu.gulimall.search.Controller;


import com.atguigu.gulimall.search.service.MallSearchService;
import com.atguigu.gulimall.search.vo.SearchParam;
import com.atguigu.gulimall.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    private MallSearchService mallSearchService;

@GetMapping("/list.html")
    public String listpage(SearchParam param, Model model, HttpServletRequest request) throws IOException {
    String queryString = request.getQueryString();
    param.set_queryString(queryString);

    //1、根据传递来的页面的查询参数，去es中检索商品
    SearchResult result = mallSearchService.search(param);
    model.addAttribute("result",result);
        return "list";
}
}
