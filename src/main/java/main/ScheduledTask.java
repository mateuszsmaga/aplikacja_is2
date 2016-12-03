package main;
import java.io.IOException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import beans.AppHelper;

@Component
public class ScheduledTask {
	
	//timer zmieniajacy flage co 5s
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws IOException {
    	AppHelper.setYouCanGrabData(true);
    }

}

