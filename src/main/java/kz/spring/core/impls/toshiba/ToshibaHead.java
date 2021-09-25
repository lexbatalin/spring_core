package kz.spring.core.impls.toshiba;

import kz.spring.core.interfaces.Head;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ToshibaHead implements Head {
	
	public void calc(){
		System.out.println("Thinking about Toshiba...");
	}

}
