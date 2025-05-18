package ch.fhnw.thrift.data.domain; 

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

    @Id
    @JsonIgnore
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String condition;
    private String fhnwLocation;
    private Long dateCreated;
    private String imageURL;

 //   @ManyToOne
 //   private List<Category> categoryList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; 
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFhnwLocation() {
        return fhnwLocation;
    }

    public void setFhnwLocation(String fhnwLocation) {
        this.fhnwLocation = fhnwLocation;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

//    public List<Category> getCategoryList() {
//        return categoryList;
//    }

//    public void setCategoryList(List<Category> categoryList) {
//        this.categoryList = categoryList;
//    }

    
    
}
