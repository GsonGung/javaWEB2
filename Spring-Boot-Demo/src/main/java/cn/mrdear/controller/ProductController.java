package cn.mrdear.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.mrdear.entity.Product;
import cn.mrdear.mapper.ProductMapper;

@Controller
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Resource
    private ProductMapper productMapper;

    @RequestMapping(value = "/findAllProds",method = RequestMethod.GET)
    public String findAllProds(Model model) {
    	List<Product> prods = productMapper.findAllProds();
    	model.addAttribute("prods", prods);
        return "product";
    }

}
