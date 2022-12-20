package aprendendo.spring.ToDoList.utils;

public class Response {
    private String msg;

    public Response() {}

    public Response(String body) {
        this.msg = body;
    }

    public String getBody() {
        return msg;
    }

    public void setBody(String body) {
        this.msg = body;
    }
}
