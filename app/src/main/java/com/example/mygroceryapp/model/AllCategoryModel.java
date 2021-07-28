package com.example.mygroceryapp.model;

public class AllCategoryModel {

    private String catName;
    private String catImage;
    private int catId;


    private int image;

    public AllCategoryModel(String catName, String catImage, int catId) {
        this.catName = catName;
        this.catImage = catImage;
        this.catId = catId;
    }

    public AllCategoryModel(String name, int img, int catId) {
        this.catName = name;
        this.image = img;
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

}
