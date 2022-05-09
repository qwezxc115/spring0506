package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex01Controller {

	@RequestMapping("/ex01/sub01")// Controller와 짝을 이룸
	public void method01() {
		System.out.println("메소드01 일 함");
	}
	
	@RequestMapping("/ex01/sub02")
	public void method02() {
		System.out.println("메소드02 일 함");
	}
}
