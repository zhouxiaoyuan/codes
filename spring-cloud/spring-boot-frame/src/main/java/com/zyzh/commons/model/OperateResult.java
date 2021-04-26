package com.zyzh.commons.model;


/**
 * <P>Title: OperateResult</P>
 * <P>Description: 包装前端的操作结果</P>
 */
public class OperateResult<T> {
    private Integer status; //操作结果 0-成功 1-失败
    private String message; //信息
    private T result; //结果数据
    /**
	 * @Description: 默认构造函数
	 */
	public OperateResult() {
		super();
	}

	/**
	 * @Description: 操作结果构造函数
	 * @param status
	 * @param message
	 */
	public OperateResult(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	/**
	 * @Description: 构造函数
	 * @param status
	 * @param result
	 */
	public OperateResult(Integer status, T result) {
		super();
		this.status = status;
		this.result = result;
	}

	/**
	 * @Description: 构造函数
	 * @param status
	 */
	public OperateResult(Integer status) {
		super();
		this.status = status;
	}

	public OperateResult(Integer status, String message, T result) {
		this(status, message);
		this.setResult(result);
	}

	public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "OperateResult [status=" + status + ", message=" + message
				+ ", result=" + result + "]";
	}
}
