package cn.fuyoushuo.fengshui.utils;

public class MsgBuilder {
	
	private int code = -1;
	private boolean ok = false;
	private String msg = null;
	private Object data = null;
	
	public static MsgBuilder create() {
		return new MsgBuilder();
	}
	
	public MsgBuilder setCode(int code) {
		this.code = code;
		return this;
	}

	public MsgBuilder setOk(boolean ok) {
		this.ok = ok;
		return this;
	}

	public MsgBuilder setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public MsgBuilder setData(Object data) {
		this.data = data;
		return this;
	}
	
	public Msg bind() {
		Msg m = new Msg();
		m.setCode(code);
		m.setOk(ok);
		m.setMsg(msg);
		m.setData(data);
		return m;
	}
}
