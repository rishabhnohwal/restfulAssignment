package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/* Add Annotation to declare this class as a JPA Entity */
@Entity @Table
@JacksonXmlRootElement
public class Blog {
    /*Add Annotation to declare this field as a Unique Identifier */
	@Id
	@JacksonXmlProperty
    private int blogId;
	
	@JacksonXmlProperty
    private String blogTitle;
	
	@JacksonXmlProperty
    private String authorName;
	
	@JacksonXmlProperty
    private String blogContent;

    /* Generate no-arg and parametrized consructor */
    public Blog() {
	}
    
    

    public Blog(int blogId, String blogTitle, String blogContent,String authorName) {
		this.authorName = authorName;
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}



	public int getBlogId() {
        return blogId;
    }

	public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
