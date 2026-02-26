package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.HeroCarouselStrategy;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataRecycleView dataRecycleView;
    List<Data> dataList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        dataList = generateProductData();

        dataRecycleView = new DataRecycleView(dataList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(dataRecycleView);


        dataRecycleView.setOnItemClickListener(new DataRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Data clickedItem = dataList.get(position);
                Toast.makeText(MainActivity.this,
                        "You clicked on: " + clickedItem.getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        dataRecycleView.setOnImageViewClickListener(new DataRecycleView.OnImageViewClickListener() {
            @Override
            public void onImageClick(ImageView iv, int position) {
                Data clickedItem = dataList.get(position);

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_image);
                ImageView dialogImage = dialog.findViewById(R.id.dialog_image_view);
                dialogImage.setImageResource(clickedItem.getImage());
                dialog.show();
            }
        });
    }

    private List<Data> generateProductData() {
        List<Data> arrayList = new ArrayList<>();
        arrayList.add(new Data("Chicken", "1770", R.drawable.chicken));
        arrayList.add(new Data("Cinnamon", "1100", R.drawable.cinnoman));
        arrayList.add(new Data("CocoCake", "770", R.drawable.cocoplate));
        arrayList.add(new Data("Fries", "1200", R.drawable.fries));
        arrayList.add(new Data("Pasta", "2200", R.drawable.pasta));
        arrayList.add(new Data("Ramen", "880", R.drawable.ramen));
        arrayList.add(new Data("Pizza", "1500", R.drawable.pasta));
        arrayList.add(new Data("Wings", "690", R.drawable.fries));
        arrayList.add(new Data("Chicken", "1770", R.drawable.chicken));
        arrayList.add(new Data("Cinnamon", "1100", R.drawable.cinnoman));
        arrayList.add(new Data("CocoCake", "770", R.drawable.cocoplate));
        arrayList.add(new Data("Fries", "1200", R.drawable.fries));
        arrayList.add(new Data("Pasta", "2200", R.drawable.pasta));
        arrayList.add(new Data("Ramen", "880", R.drawable.ramen));
        arrayList.add(new Data("Pizza", "1500", R.drawable.pasta));
        arrayList.add(new Data("Wings", "690", R.drawable.fries));
        return arrayList;
    }
}







































//public class MainActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    DataRecycleView dataRecycleView;
//
//
//
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//
//        recyclerView = findViewById(R.id.recycle_view);
//        dataRecycleView = new DataRecycleView(ProductData());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(dataRecycleView);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
//      //  CarouselStrategy carouselStrategy = new HeroCarouselStrategy();
//        //recyclerView.setLayoutManager(carouselStrategy, CarouselLayoutManager.HORIZONTAL);
//    }
//
//    public List<Data> ProductData() {
//        List<Data> arrayList = new ArrayList<>();
//        arrayList.add(new Data("Chicken", "1770", R.drawable.chicken));
//        arrayList.add(new Data("Cinnoman", "1100", R.drawable.cinnoman));
//        arrayList.add(new Data("CocoCake", "770", R.drawable.cocoplate));
//        arrayList.add(new Data("Fries", "1200", R.drawable.fries));
//        arrayList.add(new Data("Pasta", "2200", R.drawable.pasta));
//        arrayList.add(new Data("Ramen", "880", R.drawable.ramen));
//        arrayList.add(new Data("Chicken", "1770", R.drawable.chicken));
//        arrayList.add(new Data("Cinnoman", "1100", R.drawable.cinnoman));
//        arrayList.add(new Data("CocoCake", "770", R.drawable.cocoplate));
//        arrayList.add(new Data("Fries", "1200", R.drawable.fries));
//        arrayList.add(new Data("Pasta", "2200", R.drawable.pasta));
//        arrayList.add(new Data("Ramen", "880", R.drawable.ramen));
//        arrayList.add(new Data("Chicken", "1770", R.drawable.chicken));
//        arrayList.add(new Data("Cinnoman", "1100", R.drawable.cinnoman));
//        arrayList.add(new Data("CocoCake", "770", R.drawable.cocoplate));
//        arrayList.add(new Data("Fries", "1200", R.drawable.fries));
//        arrayList.add(new Data("Pasta", "2200", R.drawable.pasta));
//        arrayList.add(new Data("Ramen", "880", R.drawable.ramen));
//
//
//        return arrayList;
//
//    }
//
//}