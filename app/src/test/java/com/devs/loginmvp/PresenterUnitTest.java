package com.devs.loginmvp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.devs.loginmvp.daggerlogin.login.LoginActivityMVP;
import com.devs.loginmvp.daggerlogin.login.LoginActivityPresenter;
import com.devs.loginmvp.daggerlogin.login.User;

import org.junit.Before;
import org.junit.Test;

public class PresenterUnitTest {
    LoginActivityPresenter presenter;
    User user;

    LoginActivityMVP.Model mockedModel;
    LoginActivityMVP.View mockedView;

    @Before
    public void initialization() {
        mockedModel = mock(LoginActivityMVP.Model.class);
        mockedView = mock(LoginActivityMVP.View.class);

        user = new User("Franco", "Ortega");

        presenter = new LoginActivityPresenter(mockedModel);
        presenter.setView(mockedView);
    }

    @Test
    public void noExistsInteractionWithView() {
        presenter.getCurrentUser();

        verify(mockedView, times(1)).showUserNotAvailable();
    }

    @Test
    public void loadUserFromTheRepoWhenValidUserIsPresent() {
        when(mockedModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        verify(mockedModel, times(1)).getUser();


        verify(mockedView, times(1)).setFirstName("Franco");
        verify(mockedView, times(1)).setLastName("Ortega");
        verify(mockedView, never()).showUserNotAvailable();

    }

    @Test
    public void showErrorMessageWhenUserIsNull(){
        when(mockedModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        verify(mockedModel, times(1)).getUser();

        verify(mockedView, never()).setFirstName("Franco");
        verify(mockedView, never()).setLastName("Ortega");
        verify(mockedView, times(1)).showUserNotAvailable();

    }
    @Test
    public void createErrorMessageIfAnyFieldIsEmpty(){
        //Primera prueba poniendo el campo firstname vacío
        when(mockedView.getFirstName()).thenReturn("");

        presenter.loginButtonClicked();

        verify(mockedView, times(1)).getFirstName();
        verify(mockedView, never()).getLastName();
        verify(mockedView, times(1)).showInputError();


        //Segunda prueba poniendo un valor en el campo firstname y dejando el lastname vacío
        when(mockedView.getFirstName()).thenReturn("Franco");
        when(mockedView.getLastName()).thenReturn("");

        presenter.loginButtonClicked();

        verify(mockedView, times(2)).getFirstName();
        verify(mockedView, times(1)).getLastName();
        verify(mockedView, times(2)).showInputError();
    }
    @Test
    public void saveValidUser(){



        when(mockedView.getFirstName()).thenReturn("Sergio");
        when(mockedView.getLastName()).thenReturn("Pérez");

        presenter.loginButtonClicked();

        verify(mockedView, times(2)).getFirstName();
        verify(mockedView, times(2)).getLastName();


        verify(mockedModel, times(1)).createUser("Sergio", "Pérez");


        verify(mockedView, times(1)).showUserSaved();


    }

}
