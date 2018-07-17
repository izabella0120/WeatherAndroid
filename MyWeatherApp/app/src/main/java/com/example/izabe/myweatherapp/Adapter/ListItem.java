package com.example.izabe.myweatherapp.Adapter;

/**
 * Created by izabe on 12.07.2018.
 */

public class ListItem {

    private String my_article_tittle;
    private String my_article_subtittle;

    public ListItem(String my_article_tittle, String my_article_subtittle) {
        this.my_article_tittle = my_article_tittle;
        this.my_article_subtittle = my_article_subtittle;
    }

    public String getMy_article_tittle() {
        return my_article_tittle;
    }

    public String getMy_article_subtittle() {
        return my_article_subtittle;
    }
}
