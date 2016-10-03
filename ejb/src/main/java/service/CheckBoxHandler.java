package service;

import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Named
@RequestScoped
public class CheckBoxHandler {

    private static Logger logger = getLogger(CheckBoxHandler.class);
    private Map<Integer,Boolean> checkMap = new HashMap<Integer,Boolean>();

    public Map<Integer, Boolean> getCheckMap() {
        return checkMap;
    }
}
