package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button connexion = findViewById(R.id.btnconnexion);

        String user = "admin";
        String mdp = "1234";

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals(user) && password.getText().toString().equals(mdp)){
                    System.out.println("username : "+username.getText().toString()+"  user:"+user);
                    System.out.println("password : "+password.getText().toString()+"  mdp:"+mdp);
                    Intent next=new Intent(getApplicationContext(),AdminActivity.class);
                    startActivity(next);
                }
                else{
                    Toast toast =  Toast.makeText(view.getContext(), "Bad Credentials", Toast.LENGTH_LONG);
                    toast.show();
                    System.out.println("username : "+username.getText().toString()+"  user:"+user);
                    System.out.println("password : "+password.getText().toString()+"  mdp:"+mdp);
                }
            }
        });
    }
}