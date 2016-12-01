package main;
import java.io.IOException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    //private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    public static boolean youCanGrabData = false;
    public static String dataFormat = "XML";

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws IOException {
        //log.info("The time is now {}", dateFormat.format(new Date()));
        youCanGrabData = true;
    }

}

