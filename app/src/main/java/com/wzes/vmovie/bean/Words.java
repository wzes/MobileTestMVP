package com.wzes.vmovie.bean;

/**
 * Created by xuantang on 11/16/17.
 */

public class Words {

    public Words(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Words(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String content;
}
