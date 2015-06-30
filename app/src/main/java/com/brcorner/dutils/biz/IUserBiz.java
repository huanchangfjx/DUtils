package com.brcorner.dutils.biz;

import com.brcorner.dutils.Listener.OnLoginListener;

/**
 * Created by dong on 2015/6/29.
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
