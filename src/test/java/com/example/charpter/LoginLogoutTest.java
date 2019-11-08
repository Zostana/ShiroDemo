package com.example.charpter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

class LoginLogoutTest {

    @Test
    void testHelloword() {

        //创建manager实例
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //创建数据源realm
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        //实例绑定数据源
        defaultSecurityManager.setRealm(iniRealm);
        //把defaultSecurityManager绑定到SecurityUtils上
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("/").getPath());
        //创建用户登录令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");
        try {
            subject.login(token);
        } catch (UnknownAccountException eun) {
            System.out.println("账号错误");
        } catch (IncorrectCredentialsException es) {
            System.out.println("密码错误");
        } catch (Exception e) {
            System.out.println("未知错误");
        }

    }
}
