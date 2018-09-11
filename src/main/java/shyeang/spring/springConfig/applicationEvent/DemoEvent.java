package shyeang.spring.springConfig.applicationEvent;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1;

    private String msg;

    public DemoEvent(Object source, String  _msg) {
        super(source);
        msg = _msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
