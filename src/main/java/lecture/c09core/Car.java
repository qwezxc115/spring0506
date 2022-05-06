package lecture.c09core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Wheel wheel;
	
//	@Autowired 생성자가 하나 일 때는 생략 가능
	public Car(Wheel wheel) {
		this.wheel = wheel;
	}

	public void go() {
		wheel.roll();
	}
}
