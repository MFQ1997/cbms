package com.gdupt.cbms.core.util;

import com.gdupt.cbms.entity.shiro.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/*
* @Name：PasswordUtil
* @Description:这个是负责加密的密码类
* */

public class PasswordUtil {

    private String algorithmName = "md5";
    private int hashIterations = 2;

    /*
    * @Name:encryptPassword
    * @Description:这个是使用md5算法和加密算法
    * */
    public void encryptPassword(User user) {
        //获取md5加盐处理之后的密码串
        String newPassword = new SimpleHash(algorithmName,user.getPassword(),ByteSource.Util.bytes(user.getUserName()), hashIterations).toHex();
        user.setPassword(newPassword);
    }
}


