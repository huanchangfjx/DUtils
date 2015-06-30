package com.brcorner.dutils.Listener;

import com.brcorner.dutils.model.User;

/**
 * Created by dong on 2015/6/29.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
