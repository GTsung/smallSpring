package beans;

/**
 * @author GTsung
 * @date 2021/10/15
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {}

    @Override
    public String toString() {
        return "userService[name=" + this.name + "]";
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

}
