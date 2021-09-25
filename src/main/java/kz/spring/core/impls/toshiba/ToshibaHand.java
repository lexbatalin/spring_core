package kz.spring.core.impls.toshiba;

import kz.spring.core.interfaces.Hand;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ToshibaHand implements Hand {
	
	public void catchSomething(){
		System.out.println("Catched from Toshiba!");
	}

}
