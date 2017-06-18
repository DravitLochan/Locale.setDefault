package bharathacks.com.bharatproviders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OpenShop extends AppCompatActivity {

    EditText et_id, et_password;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_shop);

        login = (Button) findViewById(R.id.o_login);
        signup = (Button) findViewById(R.id.o_signup);
        et_id = (EditText) findViewById(R.id.o_shopid);
        et_password = (EditText) findViewById(R.id.o_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(checkNotEmpty() == true){
                    // TODO: 17-06-2017 check if login creds are correct
                }*/
                startActivity(new Intent(OpenShop.this, MainShop.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OpenShop.this, CreateShop.class));
            }
        });
    }
    public boolean checkNotEmpty()
    {
        String entry = et_id.getText().toString();
        entry = entry.trim();
        if(entry.length() == 0)
        {
            et_id.setError("can not be left empty");
            return false;
        }
        entry = et_password.getText().toString();
        entry = entry.trim();
        if(entry.length() == 0)
        {
            et_password.setError("can not be left empty");
            return false;
        }
        return true;
    }
}
