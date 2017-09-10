package com.dishu.inshorts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dishu.inshorts.adapters.NewsAdapter;
import com.dishu.inshorts.models.News;
import com.dishu.inshorts.recyclerView.DividerItemDecoration;
import com.dishu.inshorts.recyclerView.RecyclerTouchListener;
import com.dishu.inshorts.retrofit.ApiClient;
import com.dishu.inshorts.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dishu on 9/11/2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;
    List<News> lst_news;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        recyclerView = (RecyclerView) findViewById(R.id.lv_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                News news = lst_news.get(position);
                Toast.makeText(getApplicationContext(), news.getTITLE() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("url", news.getURL());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<News>> call = apiService.getAllNews();
        call.enqueue(new Callback<List<News>>() {

            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                lst_news = response.body();
                recyclerView.setAdapter(new NewsAdapter(lst_news, R.layout.list_item_news, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });
    }
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
