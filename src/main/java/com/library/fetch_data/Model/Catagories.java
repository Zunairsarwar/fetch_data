package com.library.fetch_data.Model;

import javax.persistence.*;

@Entity
@Table(name = "catagories")
public class Catagories {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "author_name")
    private String author_name;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "publish_date")
    private Integer publish_date;

    // getter ans setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
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

    @Override public String toString() {
        return "catagories{" + "id=" + id + ", book_id=" + book_id + ", customer_id=" + customer_id + ", author_name='" + author_name + '\'' + ", pages=" + pages + ", publish_date=" + publish_date + '}';
    }
}
