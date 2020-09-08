package proxy;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userId, String userName) {
        System.out.println("userManagerImpl.addUser");
    }

    @Override
    public void delUser(String userId) {
        System.out.println("userManagerImpl.delUser");
    }

    @Override
    public String findUser(String userId) {
        System.out.println("userManagerImpl.findUser");
        return "张三";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.println("userManagerImpl.modifyUser");
    }
}
