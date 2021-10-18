package com.example.appmusic;

import java.io.Serializable;

public class Songs implements Serializable
{
    private String createdAt;

    private String singerId;

    private String releaseDate;

    private String __v;

    private String name;

    private String _id;

    private String lyrics;

    private String categoryId;

    private String songUrl;

    private String updatedAt;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getSingerId ()
    {
        return singerId;
    }

    public void setSingerId (String singerId)
    {
        this.singerId = singerId;
    }

    public String getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String get__v ()
    {
        return __v;
    }

    public void set__v (String __v)
    {
        this.__v = __v;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getLyrics ()
    {
        return lyrics;
    }

    public void setLyrics (String lyrics)
    {
        this.lyrics = lyrics;
    }

    public String getCategoryId ()
    {
        return categoryId;
    }

    public void setCategoryId (String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getSongUrl ()
    {
        return songUrl;
    }

    public void setSongUrl (String songUrl)
    {
        this.songUrl = songUrl;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [createdAt = "+createdAt+", singerId = "+singerId+", releaseDate = "+releaseDate+", __v = "+__v+", name = "+name+", _id = "+_id+", lyrics = "+lyrics+", categoryId = "+categoryId+", songUrl = "+songUrl+", updatedAt = "+updatedAt+"]";
    }
}