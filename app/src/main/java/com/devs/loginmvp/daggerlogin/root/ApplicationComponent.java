package com.devs.loginmvp.daggerlogin.root;




import com.devs.loginmvp.daggerlogin.LoginActivity;
import com.devs.loginmvp.daggerlogin.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class}) //clase 33 -> minuto 5:00
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
