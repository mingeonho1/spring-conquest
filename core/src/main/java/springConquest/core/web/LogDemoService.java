package springConquest.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springConquest.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String testId) {
        myLogger.log("service id = " + testId);
    }
}
