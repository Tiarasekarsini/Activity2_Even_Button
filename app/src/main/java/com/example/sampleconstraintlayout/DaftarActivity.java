package com.example.sampleconstraintlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {
    //Deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        edtNama = findViewById(R.id.edNama);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edtAlamat = findViewById(R.id.edAlamat);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edtEmail = findViewById(R.id.EdEmail);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        edtPassword = findViewById(R.id.edPass);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edtrepass = findViewById(R.id.edrepas);

        fab = findViewById(R.id.fabSimpan);

        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    Snackbar.make(view,"Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //menampilkan pesan bahwa isi dari EditText password dan EditText repassword
                    //tidak sama
                    Snackbar.make(view, "Password dan Repassword harus sama!!!!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}