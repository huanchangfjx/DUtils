package com.brcorner.dutils.presenter;

import com.brcorner.dutils.model.User;

/**
 * Created by dong on 2015/6/29.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
