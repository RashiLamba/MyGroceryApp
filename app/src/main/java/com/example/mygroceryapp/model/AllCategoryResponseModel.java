package com.example.mygroceryapp.model;

import java.util.ArrayList;

public class AllCategoryResponseModel {
    private boolean error;
    private int count;
    private ArrayList<AllCategoryModel> data;

    public AllCategoryResponseModel(boolean error, int count, ArrayList<AllCategoryModel> data) {
        this.error = error;
        this.count = count;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<AllCategoryModel> getData() {
        return data;
    }

    public void setData(ArrayList<AllCategoryModel> data) {
        this.data = data;
    }
}
