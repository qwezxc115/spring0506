package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component // bean을 자동적으로 만들어줌
public class Car {
	
	private Engine engine;
	
	@Autowired // 자동 주입 메소드
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void go() {
		engine.action();
	}
}
