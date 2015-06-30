package com.brcorner.dutils.biz;

import com.brcorner.dutils.Listener.OnLoginListener;
import com.brcorner.dutils.model.User;

/**
 * Created by dong on 2015/6/29.
 */
public class UserBiz implements IUserBiz{
    @Override
    public void login(final String username,final String password,final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUname(username);
                    user.setUpwd(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
