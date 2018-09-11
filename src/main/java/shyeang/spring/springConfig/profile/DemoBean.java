package shyeang.spring.springConfig.profile;

public class DemoBean {
    private String content;

    public DemoBean(String s){
        content = s;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
