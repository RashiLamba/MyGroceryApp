package com.example.mygroceryapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mygroceryapp.R;
import com.example.mygroceryapp.adapters.HomeActivityAdapter;
import com.example.mygroceryapp.app.EndPoints;
import com.example.mygroceryapp.interfaces.ItemClickListener;
import com.example.mygroceryapp.model.AllCategoryModel;
import com.example.mygroceryapp.model.AllCategoryResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements ItemClickListener {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    HomeActivityAdapter homeAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AllCategoryModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    public void init(){
//        getData();
        generateData();
//        getDataM();
        recyclerView = findViewById(R.id.recyclerview_home);
        progressBar = findViewById(R.id.progressbar);
        homeAdapter = new HomeActivityAdapter(this,mList);
        layoutManager = new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAdapter);
    }

    private void getData() {
        mList.add(new AllCategoryModel("Rashi",R.drawable.ic_launcher_background,1));
        mList.add(new AllCategoryModel("Lamba",R.drawable.ic_launcher_background,2));
        mList.add(new AllCategoryModel("Sidd",R.drawable.ic_launcher_background,3));
        mList.add(new AllCategoryModel("kk",R.drawable.ic_launcher_background,4));
    }


    private void generateData() {
        RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
        String url = "https://grocery-second-app.herokuapp.com/api/category";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Log.d("TAGS",response);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int count = jsonObject.getInt("count");

                    JSONArray data = jsonObject.getJSONArray("data");
                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < count ; i++){
                        AllCategoryModel allCategoryModel = gson.fromJson(String.valueOf(data.get(i)),AllCategoryModel.class);
                        mList.add(allCategoryModel);
                    }
                    homeAdapter.setData(mList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","error in Home activity response" + error.getMessage());
            }
        });
        requestQueue.add(request);
    }


//    private void getDataM() {
//        Log.d("abc", "inside getDATA");
//        Log.d("TAG",   EndPoints.getCategory());
//        StringRequest stringRequest = new StringRequest
//                (Request.Method.GET,
//                        url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                progressBar.setVisibility(View.GONE);
//                                Gson gson = new GsonBuilder().create();
//                                AllCategoryResponseModel allCategoryResponseModel = gson.fromJson(response, AllCategoryResponseModel.class);
//                                homeAdapter.setData(allCategoryResponseModel.getData());
//                                Log.d("TAG", "Responded");
//                                //optional
//                                mList.addAll(allCategoryResponseModel.getData());
//                            }
//
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                progressBar.setVisibility(View.GONE);
//
//                                Log.d("TAG", "error" + error.getMessage());
//
//                            }
//                        }
//                );
//        Volley.newRequestQueue(this).add(stringRequest);
//
//    }


    @Override
    public void onItemClicked(View view, int Position) {
        Intent intent = new Intent(this, SubCategoryActivity.class);

    }
}