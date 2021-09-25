package com.example.mygroceryapp.app;

public class EndPoints {

    private static final String URL_CATEGORY = "category";

    public static String getCategory(){
        return Config.BASE_URL + URL_CATEGORY;
    }

}
