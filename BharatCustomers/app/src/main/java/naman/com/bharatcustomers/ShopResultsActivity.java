package naman.com.bharatcustomers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ShopResultsActivity extends AppCompatActivity {

    RecyclerView recycler;
    GridLayoutManager gridLayoutManager;
    static ShopGridAdapter gridAdapter;
    static ArrayList<Shop> shops;
    Button search;
    EditText query;

    public static void addItems(ArrayList<Shop> fetchedShops)
    {
        shops.addAll(fetchedShops);
        gridAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_results);

        shops = new ArrayList<Shop>();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(this,1);
        gridAdapter = new ShopGridAdapter(shops,getApplicationContext());
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(gridAdapter);
        search = (Button) findViewById(R.id.search);
        query = (EditText) findViewById(R.id.query);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = query.getText().toString();
                ApiHead api = new ApiHead(getApplicationContext());
                api.sendQuery(text);
                api.getAllInfo("345");
                gridAdapter.notifyDataSetChanged();
            }
        });
    }

}
