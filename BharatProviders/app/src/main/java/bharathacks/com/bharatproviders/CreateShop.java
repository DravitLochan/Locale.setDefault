package bharathacks.com.bharatproviders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateShop extends AppCompatActivity {

    EditText name_of_shop, phone_no, address, password;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shop);

        name_of_shop = (EditText) findViewById(R.id.c_name_of_shop);
        phone_no = (EditText) findViewById(R.id.c_phone_no);
        address = (EditText) findViewById(R.id.c_address);
        password = (EditText) findViewById(R.id.c_password);
        login = (Button) findViewById(R.id.c_login);
        signup = (Button) findViewById(R.id.c_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
