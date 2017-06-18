package bharathacks.com.bharatproviders;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.Pack200;

public class MainShop extends AppCompatActivity {

    RecyclerView recycler;
    GridLayoutManager gridLayoutManager;
    static ShopGridAdapter gridAdapter;
    static ArrayList<Item> items;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shop);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainShop.this, Additem.class));
            }
        });
        items = new ArrayList<Item>();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(this, 1);
        gridAdapter = new ShopGridAdapter(items, getApplicationContext());
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(gridAdapter);
        populateItems();
    }

    private void populateItems() {
        ApiHead.getProvider("345", getApplicationContext());
        gridAdapter.notifyDataSetChanged();
        //Log.d("res", str);
    }

    public static void update(ArrayList<Item> test){
        items.addAll(test);
        gridAdapter.notifyDataSetChanged();
    }
}
