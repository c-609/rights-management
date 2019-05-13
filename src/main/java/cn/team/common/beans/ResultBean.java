package cn.team.common.beans;

import cn.team.common.constant.CommonConstants;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 *
 * 返回对象包装类（带泛型）
 * create by yifeng
 */
@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 6555201656989268527L;



    /**
     * 返回的信息（出错时使用）
     */
    private String msg = "success";

    /**
     * 接口返回码
     * 0 ： 成功
     * >0 ： 表示已知异常 （需要调用地方单独处理）
     * <0 : 表示未知异常 (不需要单独处理)
     */
    private int code = CommonConstants.SUCCESS;

    
    // 临时编写 get set
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = CommonConstants.UNKNOWN_EXCEPTION;
    }
}
