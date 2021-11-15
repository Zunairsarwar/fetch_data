package com.library.fetch_data;

import javax.persistence.*;

@Entity
@Table(name = "catagories")
public class catagories {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idd")
    private Integer idd;

    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "author_name")
    private String author_name;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "publish_date")
    private Integer publish_date;

    // getter ans setter

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Integer publish_date) {
        this.publish_date = publish_date;
    }


    // toString() funstion
    @Override
    public String toString() {
        return "catagories{" +
                "idd=" + idd +
                ", book_id=" + book_id +
                ", author_name='" + author_name + '\'' +
                ", pages=" + pages +
                ", publish_date=" + publish_date +
                '}';
    }
}
