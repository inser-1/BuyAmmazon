package com.oaec.web.servlet;

import com.oaec.domain.ShopCar;
import com.oaec.service.ShopCartService;
import com.oaec.service.UserServiceImp.ShopCartServiceImp;
import com.oaec.web.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends BaseServlet {
    
    public void addCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pid = req.getParameter("pid");
        String uid = req.getParameter("uid");
        int count = Integer.parseInt(req.getParameter("count"));
        System.out.println("pid"+pid+"  uid"+uid+"  count"+count);
        ShopCartService shopCartService = new ShopCartServiceImp();
        List<ShopCar> list = shopCartService.addCart(pid,uid,count);
        double total = 0;
        for (ShopCar shopCar : list) {
          double total2 =  shopCar.getPrice() * shopCar.getPnum();
            total +=total2;
        }
        req.setAttribute("total",total);
        System.out.println(list);
         req.setAttribute("Cart",list);
        req.getRequestDispatcher("/shopping.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/shopping.jsp");
    }

    public void comeMyCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String uid = req.getParameter("uid");
        ShopCartService shopCartService = new ShopCartServiceImp();
        List<ShopCar> list = shopCartService.comeMyCart(uid);
        double total = 0;
        for (ShopCar shopCar : list) {
            double total2 =  shopCar.getPrice() * shopCar.getPnum();
            total +=total2;
        }
        req.setAttribute("total",total);
        System.out.println(list);
        req.setAttribute("Cart",list);
        req.getRequestDispatcher("/shopping.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/shopping.jsp");
    }

    public void delProductFromCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pid = req.getParameter("pid");
        String uid = req.getParameter("uid");
        ShopCartService shopCartService = new ShopCartServiceImp();
        List<ShopCar> list = shopCartService.delProductFromCart(uid,pid);
        double total = 0;
        for (ShopCar shopCar : list) {
            double total2 =  shopCar.getPrice() * shopCar.getPnum();
            total +=total2;
        }
        req.setAttribute("total",total);
        System.out.println(list);
        req.setAttribute("Cart",list);
        req.getRequestDispatcher("/shopping.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/shopping.jsp");
    }
    /* public void addProductCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        ProductViewService productViewService = new ProductViewServiceImp();
        String pid = req.getParameter("pid");
        int count = Integer.parseInt(req.getParameter("count"));
        System.out.println(count);
        Product product = productViewService.getProduct(pid);
        double subTotal = product.getPrice() * count;
        ShopCart shopCart = new ShopCart();
        shopCart.setProduct(product);
        shopCart.setPnum(count);
        shopCart.setPriceTotal(subTotal);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        Map<String, ShopCart> carts = cart.getCarts();
        if (carts.containsKey(pid) ){
            ShopCart shopCart1 = carts.get(pid);
            int oldCount =  shopCart1.getPnum() ;
            oldCount += count;
            shopCart1.setPnum(oldCount);
            cart.setCarts(carts);
        }else {
            cart.getCarts().put(String.valueOf(product.getId()),shopCart);
        }

        double priceTotal = cart.getTotal()+subTotal;
        cart.setTotal(priceTotal);
        session.setAttribute("cart",cart);
        resp.sendRedirect(req.getContextPath()+"/shopping.jsp");
    }
    public void delProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception {
            String pid = req.getParameter("pid");
            HttpSession session = req.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart!= null){
                Map<String, ShopCart> carts = cart.getCarts();
                cart.setTotal(cart.getTotal()-carts.get(pid).getPriceTotal());
                carts.remove(pid);
                cart.setCarts(carts);
            }
            session.setAttribute("cart",cart);
            resp.sendRedirect(req.getContextPath()+"/shopping.jsp");
    }*/
}
