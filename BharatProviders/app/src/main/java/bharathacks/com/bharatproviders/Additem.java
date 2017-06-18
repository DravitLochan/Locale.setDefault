package bharathacks.com.bharatproviders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Additem extends AppCompatActivity {

    EditText name, price, qty;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        name = (EditText) findViewById(R.id.product_name);
        price = (EditText) findViewById(R.id.product_price);
        qty = (EditText) findViewById(R.id.product_qty);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNotEmpty() == true){
                    String[] addParams = new String[4];
                    addParams[0] = name.getText().toString();
                    addParams[1] = price.getText().toString();
                    addParams[2] = qty.getText().toString();
                    addParams[3] = "1234567899";
                    //ApiHead.addItem(addParams);
                }
            }
        });
    }

    public boolean checkNotEmpty()
    {
        String entry = name.getText().toString();
        entry = entry.trim();
        if(entry.length() == 0)
        {
            name.setError("can not be left empty");
            return false;
        }
        entry = price.getText().toString();
        entry = entry.trim();
        if(entry.length() == 0)
        {
            price.setError("can not be left empty");
            return false;
        }
        entry = qty.getText().toString();
        entry = entry.trim();
        if(entry.length() == 0)
        {
            qty.setError("can not be left empty");
            return false;
        }
        return true;
    }
}
