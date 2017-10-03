package com.programacaobrasil.exlistviewspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Spinner spnOpcoes;
    private Button btnAdd;
    private Button btnDel;
    private ListView lstDados;

    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = (EditText)findViewById(R.id.edtValor);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button)findViewById(R.id.btnDel);
        lstDados = (ListView)findViewById(R.id.lstDados);

        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);

        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpcoes.setAdapter(adpOpcoes);

        adpOpcoes.add("Opção 1");
        adpOpcoes.add("Opção 2");
        adpOpcoes.add("Opção 3");
        adpOpcoes.add("Opção 4");

        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);
    }

    @Override
    public void onClick(View view) {
        if (view==btnAdd)
        {
            Add();
        }

        if (view==btnDel)
        {
            Del();
        }
    }

    private void Add()
    {
        String item = edtValor.getText().toString();
        item+=" - " + spnOpcoes.getSelectedItem();

        adpDados.add(item);
    }

    private void Del()
    {
        if (lstDados.getCount()>0)
        {
            String item = adpDados.getItem(0);
            adpDados.remove(item);
        }
    }
}
