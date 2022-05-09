package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularA {
	
	@Autowired
	private CircularB circularB;
	
	@Autowired
	public CircularA(CircularB circularB) {
		this.circularB = circularB;
	}

	public void run() {
		circularB.run();
	}
}
