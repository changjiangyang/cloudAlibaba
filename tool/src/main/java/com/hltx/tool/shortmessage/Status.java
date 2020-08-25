package com.hltx.tool.shortmessage;

/**
 * User: ycj
 * Date: 2020/8/14
 * Time: 9:23
 * Description:
 */
public enum Status {
    BODY(1,"消息包格式错误"),
    IP(2,"IP鉴权错误"),
    PASS(3,"账号密码不正确"),
    VERSION(4,"版本号错误"),
    other(5,"其它错误");

    int index;
    String message;

    Status(int index, String message) {
        this.index=index;
        this.message=message;
    }
}
