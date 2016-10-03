package service;

import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Named
@RequestScoped
public class TestBean {

    private static Logger logger = getLogger(TestBean.class);
    private Map<Integer,Boolean> checkMap = new HashMap<Integer,Boolean>();

    public Map<Integer, Boolean> getCheckMap() {
        return checkMap;
    }

    public String getSelected() {
        logger.info("Map {}", checkMap);
        String result = "";
        for (Map.Entry<Integer,Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                result = result + ", "+entry.getKey();
            }
        }
        return result.length() == 0 ? "" : result.substring(2);
    }


}
