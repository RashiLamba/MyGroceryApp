package com.example.mygroceryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygroceryapp.R;
import com.example.mygroceryapp.app.Config;
import com.example.mygroceryapp.model.AllCategoryModel;
import com.example.mygroceryapp.model.AllCategoryResponseModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<AllCategoryModel> mList;

    public HomeActivityAdapter(Context context, ArrayList list){
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_category_recycler_view,parent,false);
//        view.setOnClickListener(mOnClickListener);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllCategoryModel allCategoryModel = mList.get(position);
        holder.textViewCategoryName.setText(allCategoryModel.getCatName());
        String imageUrl = Config.IMAGE_URL + allCategoryModel.getCatImage();
        Picasso.get()
                .load(imageUrl)
                .fit()
                .error(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.imageViewCategoryPic);
    }


    public void setData(ArrayList<AllCategoryModel> arrayList){
        this.mList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategoryName;
        ImageView imageViewCategoryPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCategoryName  = itemView.findViewById(R.id.text_view_category_name);
            imageViewCategoryPic = itemView.findViewById(R.id.image_view_category_pic);
        }
    }



//    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(mContext, "hello", Toast.LENGTH_SHORT).show();
//        }
//    };

}
