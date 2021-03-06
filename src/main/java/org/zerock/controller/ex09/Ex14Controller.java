package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.service.ex02.Ex04Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {

	@Autowired
	private Ex04Service service;

	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// 1. request parameter 수집/ 가공
		// 2. bussiness logic 처리
		String name = service.getNameById(id);

		// 3. model.addAttribute
		model.addAttribute("name", name);
		// 4. forward/redirect

	}

	// /ex14/sub02?id=3
	// view에서 Employee의 firstName이 출력 되도록

	// controller.method02 완성
	// service에도 메소드 추가
	// mapper에도 메소드 추가
	// jsp 작성
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		String firstName = service.getEmployeeFristNameById(id);

		model.addAttribute("employeeName", firstName);

	}

	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);

		model.addAttribute("customer", dto);

	}

	// /ex14/sub04?id=7
	// 직원의 FirstName, LastName이 모두 jsp 출력되도록

	// controller에 새 메소드 작성
	// service에 새 메소드 작성
	// mapper에 새 메소드 작성
	// 새 jsp 파일 작성
	// EmployeeDto 새로 작성
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getEmployeeById(id);

		model.addAttribute("employee", dto);
	}
	
	@GetMapping("sub05")
	public void method05() {
		// form 있는 jsp forward
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		
		System.out.println(customer);
		
		boolean ok = service.addCustomer(customer);
		
		if (ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		
		return "redirect:/ex14/sub05";
	}
	
	@GetMapping("sub06")
	public void method07() {
		
	}
	
	/* 직원 등록*/
	@PostMapping("sub06")
	public String method08(EmployeeDto employee, RedirectAttributes rttr) {
		
		boolean ok = service.addEmployee(employee);
		
		if (ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	@GetMapping("sub07")
	public void method09(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		
		model.addAttribute("employees", list);
	}

	// 고객 목록 조회 코드 작성
	@GetMapping("sub08")
	public void method08(Model model) {
		List<CustomerDto> list = service.listCustomer();
		
		model.addAttribute("customers", list);
	}
	
	// /ex14/sub09
	@GetMapping("sub09")
	public void method10(@RequestParam(name = "page", defaultValue="1")int page, Model model) {
		
		int rowPerPage = 5;
		
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		
		model.addAttribute("customers", list);
	}
}













