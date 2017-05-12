package com.kyrostechnologies.template.social.model;

/**
 * Created by muslim on 11/11/2015.
 */
public class Feed {
    private long id;
    private String date;
    private Friend friend;
    private String text = null;
    private int photo = -1;

    public Feed() {
    }

    public Feed(long id, String date, Friend friend, String text, int photo) {
        this.id = id;
        this.date = date;
        this.friend = friend;
        this.text = text;
        this.photo = photo;
    }
    public Feed(long id, String date, Friend friend, String text) {
        this.id = id;
        this.date = date;
        this.friend = friend;
        this.text = text;
    }
    public Feed(long id, String date, Friend friend, int photo) {
        this.id = id;
        this.date = date;
        this.friend = friend;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Friend getFriend() {
        return friend;
    }

    public String getText() {
        return text;
    }

    public int getPhoto() {
        return photo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
