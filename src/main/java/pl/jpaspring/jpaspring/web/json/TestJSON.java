package pl.jpaspring.jpaspring.web.json;

public class TestJSON {

    private final long id;
    private final String content;

    public TestJSON(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}