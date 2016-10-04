package service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class CheckBoxHandler {

    private Map<Integer,Boolean> checkMap = new HashMap<Integer,Boolean>();

    public Map<Integer, Boolean> getCheckMap() {
        return checkMap;
    }
}
