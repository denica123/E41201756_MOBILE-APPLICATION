package com.deni.listview;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements TextWatcher {

    //Variabel Array untuk menyimpan data Studi
    public String[]datastudi=
            {
                    "TK","SD","SMP","SMA/SMK","S1",
                    "S2"
            };
    //Variabel Array untuk menyimpan data Studi
    public String[]datadomisili=
            {
                    "Nganjuk","Kediri","Blitar","Malang","Pasuruan","Sidoarjo",
                    "Surabaya","Madura","Bondowoso","Probolinggo","Lumajang","Jember"
            };

    //inisialisasi Variabel
    Spinner jeniskelamin;
    EditText lis;

    //fungsi autocomplete
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fungsi autocomplete mencari nama domisili/daerah
        AutoCompleteTextView act = findViewById(R.id.dataautocomplete);
        ArrayAdapter<String> adapterdatadomisili = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datadomisili);
        act.setAdapter(adapterdatadomisili);

        //Spinner pilihan jenis kelamin
        jeniskelamin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> gender = ArrayAdapter.createFromResource(this,R.array.jeniskelamin, android.R.layout.simple_spinner_dropdown_item);
        gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jeniskelamin.setAdapter(gender);

        jeniskelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Gender = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Pilih:" +Gender, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //fungsi listview Data Studi
    public void pilihstudi(View v)
    {
        lis=(EditText)findViewById(R.id.datalistview);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Data Studi ");
        builder.setItems(datastudi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
                lis.setText(datastudi[item]);
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }



    
    


    
}