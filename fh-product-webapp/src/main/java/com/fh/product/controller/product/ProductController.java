package com.fh.product.controller.product;

import com.fh.product.aop.LogAnnotation;
import com.fh.product.bean.Product;
import com.fh.product.bean.User;
import com.fh.product.service.product.IProductService;
import com.fh.product.service.rabbit.IRabbitService;
import com.fh.product.service.user.IUserRedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("ProductController")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IRabbitService rabbitService;

    @Autowired
    private IUserRedisService userRedisService;


    @RequestMapping("product")
    @LogAnnotation(methodInfo="跳转到商品页面")
    public String product(){
        return "product";
    }


    @RequestMapping("queryProductPageList")
    @ResponseBody
    @LogAnnotation(methodInfo="查询商品分页")
    public Map queryProductPageList(Product product, @RequestParam("draw") Integer draw, @RequestParam("start") Integer start, @RequestParam("length") Integer length){
        return productService.queryProductPageList(product,draw,start,length);
    }


    @RequestMapping("addProduct")
    @ResponseBody
    @LogAnnotation(methodInfo="增加商品")
    public Map addProduct(Product product){
      // productService.addProduct(product);
        return  rabbitService.addProduct(product);
    }


    @RequestMapping("delProductById")
    @ResponseBody
    @LogAnnotation(methodInfo="删除商品")
    public Map delProductById(@RequestParam("productId") String productId){
        return productService.delProductById(productId);
    }


    @RequestMapping("queryProductById")
    @ResponseBody
    @LogAnnotation(methodInfo="回显商品")
    public Map queryProductById(@RequestParam("productId") String productId){
        return productService.queryProductById(productId);
    }


    @RequestMapping("updateProduct")
    @ResponseBody
    @LogAnnotation(methodInfo="修改商品")
    public Map updateProduct(Product product){
        return productService.updateProduct(product);
    }


    @RequestMapping("addCart")
    @ResponseBody
    @LogAnnotation(methodInfo="加入购物车")
    public void addCart(Product product){
        //从session中获取当前用户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String productId=product.getProductId();
        //去数据库查询商品信息
        Product pro=productService.queryProductByIdCart(productId);
        String key="cart"+user.getUserId();

        //查询该商品是否存在
        boolean isExist=userRedisService.hasKey(key,productId);
        if (isExist){
            //查询存在的商品信息
            Product proCart=userRedisService.hget(key,productId);
            //将前台商品数量和redis里的数量相加
            Integer num=product.getNum()+proCart.getNum();
            pro.setNum(num);
            //给商品的小计赋值
            pro.setProductPriceNmu(num*pro.getProductPrice());
            //存入redis
            userRedisService.setHashOption(key,productId,pro);
        }else {
            //获取前台购买的数量
            pro.setNum(product.getNum());
            //给商品小计赋值
            pro.setProductPriceNmu(product.getNum()*pro.getProductPrice());
            //存入redis
            userRedisService.setHashOption(key,productId,pro);
        }
    }

    @RequestMapping("queryCart")
    @LogAnnotation(methodInfo="查询购物车")
    public ModelAndView queryCart(Product product){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String key="cart"+user.getUserId();
        //查询出购物车中的所有商品
        List<Product> productList=userRedisService.hgetList(key);
        ModelAndView mav=new ModelAndView("cart");
        mav.addObject("productList",productList);
        return mav;
    }

    @RequestMapping("cartNum")
    @ResponseBody
    @LogAnnotation(methodInfo="修改商品购买数量")
    public void cartNum(Product product){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String key="cart"+user.getUserId();
        //从redis中查询出商品信息
        Product proCart=userRedisService.hget(key,product.getProductId());
        //给数量赋值
        proCart.setNum(product.getNum());
        //计算出商品小计
        proCart.setProductPriceNmu(product.getNum()*proCart.getProductPrice());
        //存入数据库
        userRedisService.setHashOption(key,proCart.getProductId(),proCart);
    }

    @RequestMapping("delCartProduct")
    @ResponseBody
    @LogAnnotation(methodInfo="删除商品")
    public void delCartProduct(Product product){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String key="cart"+user.getUserId();

        //删除当前用户购物车中的某个商品
        userRedisService.deleteHash(key,product.getProductId());
    }

    @RequestMapping("deleteSelectProduct")
    @ResponseBody
    @LogAnnotation(methodInfo="删除选中的商品")
    public void deleteSelectProduct(Product product){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String key="cart"+user.getUserId();

        //删除当前用户购物车中的某个商品
        if (StringUtils.isNotBlank(product.getProductIds())) {
            String[] productidarr = product.getProductIds().split(",");
            for (String productId : productidarr) {
                userRedisService.deleteHash(key,productId);
            }

        }
    }

//    @RequestMapping("selectProductNum")
//    @ResponseBody
//    @LogAnnotation(methodInfo="计算选中的数量")
//    public void selectProductNum(Product product){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        User user = (User) request.getSession().getAttribute("user");
//        String key="cart"+user.getUserId();
//
//
//        if (StringUtils.isNotBlank(product.getProductIds())) {
//            String[] productidarr = product.getProductIds().split(",");
//            for (String productId : productidarr) {
//                Product proCart=userRedisService.hget(key,productId);

//                proCart.setNumSum(product);
//            }
//            userRedisService.setHashOption(key,proCart.getProductId(),proCart);
//        }
//    }







}
