package com.android.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.cardview.R;
import com.android.cardview.adapter.PostagemAdapter;
import com.android.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //criando atributo RecyclerView
    private RecyclerView recyclerPostagem;

    //criando uma listagem para guardar os itens
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerViewId);

        //definir layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //dessa forma as postagens mudam lateralmente
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);

        //divide as postagens em colunas - no caso está dividido em 2 colunas
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);


        //definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager( layoutManager );

        //definir adapter

        this.prepararPostagens(); //chama o método que cria as postagens
        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );
    }


    /*
    * para carregarmos de forma simples as postagens
    * */
    public void prepararPostagens(){

        Postagem post = new Postagem("Caroline Machado Borges", "#tbt Viagem incrível!", R.drawable.imagem1);
        this.postagens.add( post );

        post = new Postagem("Hotel MB", "Aproveite os descontos", R.drawable.imagem2);
        this.postagens.add( post );

        post = new Postagem("Jessica ", "Paris", R.drawable.imagem3);
        this.postagens.add( post );

        post = new Postagem("Conceição", "Foto maravilhosa", R.drawable.imagem4);
        this.postagens.add( post );


    }
}
