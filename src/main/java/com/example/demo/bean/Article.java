package com.example.demo.bean;

public class Article {
    private Integer id;
    private Integer uid;
    private String pic;
    private String title;
    private String content;
    private String created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return
                "id:" + this.getId() + ","
                + "uid:" + this.getUid() + ","
                + "pic:" + this.getPic() + ","
                + "title:" + this.getTitle() + ","
                + "content:" + this.getContent() + ","
                + "created_at:" + this.getCreated_at() + ","
                ;
    }
}
