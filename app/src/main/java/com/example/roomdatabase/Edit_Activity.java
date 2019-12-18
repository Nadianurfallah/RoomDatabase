package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.activity.AddUserActivity;
import com.example.roomdatabase.activity.DetailActivity;
import com.example.roomdatabase.room.Mahasiswa;

import static com.example.roomdatabase.AppApplication.db;

public class Edit_Activity extends AppCompatActivity {

    Mahasiswa mahasiswa;
    private Button Editdata;
    private  EditText nama, nim, kejuruan, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);

        Editdata = findViewById(R.id.btEdit);
        alamat = findViewById(R.id.etAlamat);
        kejuruan= findViewById(R.id.etKejuruan);
        nim = findViewById(R.id.etNim);
        nama = findViewById(R.id.etNama);

        Editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setAlamat(alamat.getText().toString());
                mahasiswa.setKejuruan(kejuruan.getText().toString());
                mahasiswa.setNama(nim.getText().toString());
                mahasiswa.setNim(nama.getText().toString());
                //Insert data in database
                db.userDao().insertAll(mahasiswa);
                startActivity(new Intent(Edit_Activity.this, DetailActivity.class));
                finish();
            } else{
                Toast.makeText(getApplicationContext(), "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
            }
    });
}
}