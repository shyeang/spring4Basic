package shyeang.spring.springH.jUnitTest;

public class TestBean {
    private String content;
    public TestBean(String c){
        content = c;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
