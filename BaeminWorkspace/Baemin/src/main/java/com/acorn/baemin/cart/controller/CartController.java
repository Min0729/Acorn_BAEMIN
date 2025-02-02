package com.acorn.baemin.cart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acorn.baemin.cart.domain.CartDTOTest;
import com.acorn.baemin.cart.service.CartServiceImp;

public class CartController {

	@Autowired
	CartServiceImp cartService;

	@GetMapping("/cartList")
	public String cartList(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			String id = "test01";
			System.out.println(cartService.cartList(id));
			Map<String, List> cartMap = cartService.cartList(id);
			session.setAttribute("cartMap", cartMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home/cart_list";
	}
}
