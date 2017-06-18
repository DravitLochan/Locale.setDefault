package bharathacks.com.bharatproviders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by DravitLochan on 17-06-2017.
 */

public class ShopGridAdapter extends RecyclerView.Adapter<ShopGridAdapter.ViewHolder>{

    ArrayList<Item> items;
    Context context;

    public ShopGridAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ShopGridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShopGridAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(items.get(position).getUrl()).into(holder.photo);
        holder.product_name.setText(items.get(position).getName());
        holder.price.setText(items.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView product_name, price;
        public ViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.item_image);
            product_name = (TextView) itemView.findViewById(R.id.item_name);
            price = (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}
