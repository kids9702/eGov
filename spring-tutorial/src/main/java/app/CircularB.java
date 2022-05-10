package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class CircularB {
	
	@Autowired
	private CircularA circularA;
	
	public CircularB(CircularA circularA) {
		super();
		this.circularA = circularA;
	}

	public void run() {
		circularA.run();
	}
}
