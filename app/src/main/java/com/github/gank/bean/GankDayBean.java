package com.github.gank.bean;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/25 0025:10:48
 * 修改人员：hewking
 * 修改时间：2019/2/25 0025 10 48
 * 修改备注：
 * Version: 1.0.0
 */
@Entity(tableName = "t_gankday")
public class GankDayBean {

    /**
     * _id : 5c0622429d2122308e7445cf
     * createdAt : 2018-12-04T06:44:18.364Z
     * desc : 一个基于ijkplayer的完整视频播放器封装，支持自定义，拓展性强，已经用于实际开发中
     * images : ["http://img.gank.io/0cd8baa4-7d96-40fb-ab0c-4b3668a7ac4d","http://img.gank.io/35066fc9-4c67-498d-b9e1-f8e3ca7410e1","http://img.gank.io/ad8b369e-c643-4631-afdd-4466aab4f7fd","http://img.gank.io/101d45df-c66b-4610-809a-734fbca99967","http://img.gank.io/d8755a02-fe71-4562-ac9f-4d7d6b0d3358"]
     * publishedAt : 2019-02-13T03:26:06.640Z
     * source : web
     * type : Android
     * url : https://github.com/yangchong211/YCVideoPlayer
     * used : true
     * who : fingdo
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
//    @ColumnInfo(name = "")
    private boolean used;
    private String who;
    @Ignore
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "GankDayBean{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                ", images=" + images +
                '}';
    }
}
