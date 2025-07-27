package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

// @Controller - 해당 클래스의 인스턴스를 스프링의 bean으로 등록하고 컨트롤러로 사용
// 		- <component-scan>에서 위치를 등록해서 같이 사용
@Controller
/* 스프링 4.3전까지는 @RequestMapping(method='get') 방식으로 사용
 * 스프링 4.3이후에는 @GetMapping, @PostMapping 방식으로 간단한 표현 가능
 */
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..........");
	}
	
	@GetMapping("/basicGET")
	public void basicGet() {
		log.info("basic get..............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("dto : " + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam("name") String name, int age) {
		
		log.info(name);
		log.info(age);
		
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
	
		
		return "ex02List";
	}
	
	// http://localhost:8080/sample/ex02Bean?list[0].name=AAA&list[0].age=16
	// http://localhost:8080/codingdan/sample/ex02Bean?list%5B0%5D.name=AAA&list%5B0%5D.age=16
	@GetMapping("/ex02Bean")
	public String ex02Bean(@ModelAttribute("sample") SampleDTOList list, Model model)  {
		
		log.info(list);
		
		model.addAttribute("result", "success");
		return "sample/ex02Bean";
	}
	// 	- Model 객체는 jsp에 콘트롤러에서 생성된 데이터를 담아서 전달하는 역할을 한다
	// 	- 모델 2 방식에서 사용하는 request.setAttribute()와 유사한 역할
	// 	- 과거에는 ModelAndView
	// 	- Model에 담는 데이터 -> 파라미터가 아니라 다른 곳에서 발생한 데이터를 담기 위한 용기
	 
	// RedirectAttribute
	// 	- 화면에 한번만 전달되는 파라미터를 처리하는 용도
	// 	- 내부적으로 HttpSession 객체에 담아서 한번만 사용되고, 폐기
	// 
	// rttr.addFlashAttribute("name","AAA");
	// 		rttr.addFlashAttribute("age",10);
	//
	//	return "redirect:/";
	
	// response.sendRedirect("/home?name=aaa&age=10);
}
