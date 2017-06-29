package com.example.zhou.player.DoMain;

/**
 * Created by zhou on 2017/5/26.
 * 多媒体文件解析
 */

public class MediaItemBean {
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件时长
     */
    private long duration;
    /**
     * 文件大小
     */
    private long size;
    /**
     * 文件绝对地址
     */
    private String data;
    /**
     * 文件作者
     */
    private String artist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "MediaItemBean{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                ", data='" + data + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
