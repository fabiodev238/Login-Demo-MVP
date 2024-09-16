package com.devs.loginmvp.daggerlogin.login;

public interface LoginRepository {

    void saveUser(User user);

    User getUser();
}
