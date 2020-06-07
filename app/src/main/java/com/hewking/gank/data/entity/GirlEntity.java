package com.hewking.gank.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "t_girl")
public class GirlEntity {

    /**
     * _id : 5e8c808e31ec89ebfc601f0f
     * author : 鸢媛
     * category : Girl
     * createdAt : 2020-04-09 08:00:00
     * desc : 希望你以后喜欢的人，
     不会让你哭不会让你受委屈
     不会不理你更不会放弃你
     最好一直陪着你，保护你
     最重要的是深深的无可救药的喜欢你。
     * images : ["http://gank.io/images/e831e004436f4fffb657a77aef48b9ca"]
     * likeCounts : 1
     * publishedAt : 2020-04-09 08:00:00
     * stars : 1
     * title : 第50期
     * type : Girl
     * url : http://gank.io/images/e831e004436f4fffb657a77aef48b9ca
     * views : 125
     */

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("_id")
    @NotNull
    private String id;
    private String author;
    private String category;
    private String createdAt;
    private String desc;
    private int likeCounts;
    private String publishedAt;
    private int stars;
    private String title;
    private String type;
    private String url;
    private int views;
    private List<String> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(int likeCounts) {
        this.likeCounts = likeCounts;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
