package com.samansepahvand.changefontrecyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.samansepahvand.changefontrecyclerview.R;
import com.samansepahvand.changefontrecyclerview.adapter.MyAdapter;
import com.samansepahvand.changefontrecyclerview.client.ApiClient;
import com.samansepahvand.changefontrecyclerview.client.ApiReference;
import com.samansepahvand.changefontrecyclerview.model.DataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  ArrayList<DataModel> dataModels=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void getData() {

        ApiReference apiService = ApiClient.getClient().create(ApiReference.class);
        Call<ArrayList<DataModel>> call = apiService.getPosts();
        call.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {

                if (response.isSuccessful()){
                    Log.e("TAG", "onResponse: "+response );

                    dataModels=response.body();
                    recyclerView.setAdapter(new MyAdapter(dataModels,MainActivity.this));
                }else{
                    Log.e("TAG", "onResponse Error: "+response );
                }

            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {

                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });


    }
    private void initView() {

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}