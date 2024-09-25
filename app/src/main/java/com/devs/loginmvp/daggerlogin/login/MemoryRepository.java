package com.devs.loginmvp.daggerlogin.login;

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public void saveUser(User user) {
        if(user == null){
            user = getUser();
        }
        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null){
            user = new User("Franco", "Colapinto");
            return user;
        }else {
            return user;
        }
    }
}
