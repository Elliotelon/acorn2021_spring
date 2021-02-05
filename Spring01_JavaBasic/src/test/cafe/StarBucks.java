package test.cafe;

import org.springframework.stereotype.Component;

@Component
public class StarBucks {
	public void orderOne(Americano a) {
		System.out.println("orderOne()");
	}
	public void orderTwo(Latte l, Americano a) {
		System.out.println("orderTwo()");
	}
	public void orderThree(Latte l, Milk m, Americano a) {
		System.out.println("orderThree()");
	}
}
