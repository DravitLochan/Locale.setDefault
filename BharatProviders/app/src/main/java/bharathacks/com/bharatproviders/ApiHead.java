package bharathacks.com.bharatproviders;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by DravitLochan on 17-06-2017.
 */

public class ApiHead {
    private static final String hitpoint="http://192.178.5.30:3000/";
    public static void getProvider(String contactNum, Context context) {

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, hitpoint + "getvendorinfo?contact="+contactNum,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("response",response);
                            String url = "https://cdn.pixabay.com/photo/2015/03/28/21/25/can-696583_150.jpg";
                            ArrayList<Item> items = new ArrayList<Item>();
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String qty = jsonObject.get("quantity").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            String price = jsonObject.get("price").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            String name = jsonObject.get("item").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            ArrayList<String> q = convertToArray(qty);
                            Log.i("qty", qty.toString());
                            Log.i("q", q.toString());
/*                            for(int i =0; i<count; ++i)
                            {
                                items.add(new Item(url, "ma chuda", "ma chuda"));
                            }
*/
                            MainShop.update(items);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private static ArrayList<String> convertToArray(String qty) {
        ArrayList<String> arr = new ArrayList<String>();
        char shit = qty.charAt(1);
        int i = 1;
        while(true){
            String t = "";
            while(qty.charAt(i)!=','&&qty.charAt(i)!=']'){
                t+=qty.charAt(i);
                ++i;
            }
            if(qty.charAt(i)==']'){
                break;
            }
            else if(qty.charAt(i)==','){
                arr.add(t);
                ++i;
            }
        }
        String t=""+qty.charAt(qty.length()-2);
        arr.add(t);
        return arr;
    }

    static int getCount(String str, char c){
        int i, ctr = 0;
        for(i=0; str.charAt(i)!='\0';++i){
            ++ctr;
        }
        return ctr;
    }

    private static boolean addItem(Context context, ArrayList<String> params){
        boolean resp = true;
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, hitpoint +"update?",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("response",response);
                            String url = "https://cdn.pixabay.com/photo/2015/03/28/21/25/can-696583_150.jpg";
                            ArrayList<Item> items = new ArrayList<Item>();
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String qty = jsonObject.get("quantity").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            String price = jsonObject.get("price").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            String name = jsonObject.get("item").toString().replace("\"\\","").replace("\\\"","").replace("\"","");
                            ArrayList<String> q = convertToArray(qty);
                            Log.i("qty", qty.toString());
                            Log.i("q", q.toString());
/*                            for(int i =0; i<count; ++i)
                            {
                                items.add(new Item(url, "ma chuda", "ma chuda"));
                            }
*/
                            MainShop.update(items);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        return resp;
    }
}