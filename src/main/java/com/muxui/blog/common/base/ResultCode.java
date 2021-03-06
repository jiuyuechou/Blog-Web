package com.muxui.blog.common.base;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：10000
 *      失败：10001
 *      未登录：10002
 *      未授权：10003
 *      抛出异常：99999
 */
public enum ResultCode {

    SUCCESS(true,10000,"操作成功！"),
    //---系统错误返回码-----
    FAIL(false,10001,"操作失败"),
    UNAUTHENTICATED(false,10002,"您还未登录"),
    UNAUTHORISE(false,10003,"权限不足"),
    INVALID_TOKEN(false, 10004,"token解析失败" ),
    //---权限操作返回码----
    //---其他操作返回码----
    CAPTCHA_ERROR(false,100004,"验证码错误"),
    ACCOUNT_EXIST(false,100005, "账户已存在"),
    DATA_NO_EXIST(false, 100006,"该数据不存在"),
    PARAM_INCORRECT(false, 88888,"传入参数有误"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    //---用户操作返回码  2xxxx----
    LOGINSUCCESS(true,20000,"登录成功！"),
    MOBILEORPASSWORDERROR(false,20001,"用户名或密码错误"),
    USERNOTEXIST(false,20002,"账户不存在，请注册！"),
    NOTLOGGED(false,20003,"未登录，请先登录！"),
    LOGIN_DISABLE(false,20004,"账户已被禁用,请联系管理员解除限制"),
    UPDATE_PASSWORD_ERROR(false,20005,"密码修改失败！");



    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
