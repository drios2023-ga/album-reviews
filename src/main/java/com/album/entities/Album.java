package com.album.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class Album {
 //**************************************** */
    //  Entity Properties
    //**************************************** */

    @Id //Denotes this property as the id/primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto generates
    public Integer id;

    public String title;
    public Date reviewDate;
    public String review;

    //**************************************** */
    //  Constructors
    //**************************************** */

    public Album(){

    }

    public Album(String title, Date reviewDate, String review){
        this.title = title;
        this.reviewDate = reviewDate;
        this.review = review;
    }

    //**************************************** */
    //  GETTERS AND SETTERS
    //**************************************** */

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Date getReviewDate(){
        return this.reviewDate;
    }

    public void setReviewDate(Date reviewDate){
        this.reviewDate = reviewDate;
    }   
    
    public String getReview(){
        return this.review;
    }

    public void setReview(String review){
        this.review = review;
    }    
}
