package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component
@ToString
public class Computer {

	// setter에 autowired를 붙이려고 함
	// 여러 개의 어노테이션을 붙일땐 {}를 붙여 ,를 사용
	@Setter(onMethod_ = @Autowired )
	private Memory memory;

//	@Autowired
//	public void setMemory(Memory memory) {
//		this.memory = memory;
//	}
}
