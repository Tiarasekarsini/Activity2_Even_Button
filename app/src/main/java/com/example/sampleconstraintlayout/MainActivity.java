package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            //method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //Menyimpan input user di edittext email kedalam variabel nama
            nama = edemail.getText().toString();
            //Menyimpan input user di edittext password kedalam variabel password
            password = edpassword.getText().toString();

            //Mengecek apakah edittext email dan password sesuai atau tidak (valid atau tidak) isinya
            if (nama.equals("admin@mail.com") && password.equals("123")){
                Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                //inisiasi
                Bundle bn = new Bundle();

                //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                bn.putString("a", nama.trim());

                //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                bn.putString("b", password.trim());

                //membuat objek intent berpindah activity dari mainactivity ke ActivityKedua (memanggil dan yang dipanggil)
                Intent i = new Intent(MainActivity.this,ActivityKedua.class);

                //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityKedua
                i.putExtras(bn);

                //berpindah ke ActivityKedua
                startActivity(i);
            }
           else if (nama.equals("admin@mail.com") && password.equals(password)){
                Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
            }
            else if ( nama.equals(nama) && password.equals("123")){
                //Toast.makeText(MainActivity.this, "Email yang Anda masukkan salah", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Email dan Password salah", Toast.LENGTH_SHORT).show();
            }
        }
    });

}}