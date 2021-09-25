package kz.spring.core.impls.toshiba;

import kz.spring.core.interfaces.Leg;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ToshibaLeg implements Leg {
	
	public void go(){
		System.out.println("Go to Toshiba!");
	}

}
