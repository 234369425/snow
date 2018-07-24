package com.beheresoft.website.controller;

import com.beheresoft.website.service.MarkDownArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Aladi
 */
@Controller
@RequestMapping("/article/md/")
public class MarkDownArticleController {

    private MarkDownArticleService markDownArticleService;

    public MarkDownArticleController(MarkDownArticleService articleService) {
        this.markDownArticleService = articleService;
    }

    @RequestMapping("/get/{hashcode}")
    public ModelAndView get(@PathVariable("hashcode") Long hashCode) {
        this.markDownArticleService.search(hashCode);
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("markdown");
        modelAndView.addObject("value", markDownArticleService.get());
        return modelAndView;
    }

}
