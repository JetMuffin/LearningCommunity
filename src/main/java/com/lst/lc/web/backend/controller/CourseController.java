package com.lst.lc.web.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lst.lc.dao.CategoryDao;
import com.lst.lc.dao.DirectionDao;
import com.lst.lc.entities.Category;
import com.lst.lc.entities.Direction;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	@Qualifier("categoryDao")
	private CategoryDao categoryDao;

	@Autowired
	@Qualifier("directionDao")
	private DirectionDao directionDao;

	public CourseController() {
		super();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		List<Direction> directions = directionDao.getAllDirections();
		List<Category> categories = categoryDao.getAllCategories();
		model.addAttribute("directions", directions);
		model.addAttribute("categories", categories);
		return "backend/course/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String title, String description, String difficulty,
			String imageUrl, String category, String direction) {
		
		return null;
	}

}