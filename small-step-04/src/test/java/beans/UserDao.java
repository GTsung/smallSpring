package beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("10001", "小明");
        map.put("10002", "刘萧的妈妈");
        map.put("10003", "刘萧的媳妇");
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }

}
