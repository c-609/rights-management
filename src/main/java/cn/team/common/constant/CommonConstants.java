package cn.team.common.constant;

/**
 * 常量维护
 * create by yifeng
 */
public interface CommonConstants {

    /**
     * 正常
     */
    int STATUS_NORMAL = 0;

    /**
     * 删除
     */
    int STATUS_DEL = 101;

    /**
     * 锁定
     */
    Integer STATUS_LOCK = 102;

    /**
     * 未登录
     */
    public final int NO_LOGIN = -1;

    /**
     * 用户或密码错误
     */
    public final int USERNAME_OR_PASSWORD_NON = 3;

    /**
     * 成功
     */
    public final int SUCCESS = 0;

    /**
     * 验证失败
     */
    int CHECK_FAIL = 1;

    /**
     * 没有权限
     */
    public final int NO_PERMISSION = 2;

    /**
     * 未知错误
     */
    public final int UNKNOWN_EXCEPTION = -99;

}
