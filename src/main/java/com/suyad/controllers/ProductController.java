package com.suyad.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suyad.Entitys.Product;
import com.suyad.repo.ProductRepo;

@Controller
public class ProductController 
{
	@Autowired
	ProductRepo r;
	
	@GetMapping("/")
	public String loadForm(Model m)
	{
		m.addAttribute("p", new Product());
		return "index";
	}
	@PostMapping("/product")
	public String saveproduct(@Validated @ModelAttribute("p")Product p,BindingResult result ,Model m)
	{
		if(result.hasErrors())
		{
			return "index";
		}
		Product save = r.save(p);
		System.out.println(p);
		if(save.getPid()!=null)
		{
			m.addAttribute("msg", "Product saved Successfully");
		}
		else
		{
			m.addAttribute("msg", "Product not saved");
		}
		return "index";
	}
	@GetMapping("/products")
	public String getAllproducts(Model m)
	{
		List<Product> findAll = r.findAll();
		m.addAttribute("products", findAll);
		return "data";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("pid")Integer pid,Model m)
	{
		r.deleteById(pid);
		m.addAttribute("msg", "product deleted");
		List<Product> findAll = r.findAll();
		m.addAttribute("products", findAll);
		return "data";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam("pid")Integer pid,Model m)
	{
		Optional<Product> findById = r.findById(pid);
		if(findById.isPresent())
		{
			Product pro = findById.get();
			m.addAttribute("p", pro);
		}
		return "index";
	}
}
