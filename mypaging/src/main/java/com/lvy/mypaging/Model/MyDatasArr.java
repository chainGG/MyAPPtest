package com.lvy.mypaging.Model;

import java.util.Objects;

public class MyDatasArr {
    public  String id;
    public  String post_title;
    public  String post_excerpt;
    public  String thumbnail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDatasArr that = (MyDatasArr) o;
        return id.equals( that.id) &&
                post_title.equals( that.post_title) &&
                post_excerpt.equals( that.post_excerpt) &&
                thumbnail.equals( that.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post_title, post_excerpt, thumbnail);
    }
}
