package cn.fuyoushuo.fengshui.utils;

public class Msg {

	private int code = -1;
	private boolean ok ;
	private String msg;
	private Object data;

	public Msg() { }
	
	public Msg(boolean ok, String msg) {
		super();
		this.ok = ok;
		this.msg = msg;
	}

	public Msg(boolean ok, String msg, Object data) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public void clear() {
		setCode(-1);
		setMsg(null);
		setOk(false);
		setData(null);
	}

	
}
