package com.android.cardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cardview.R;
import com.android.cardview.model.Postagem;

import java.util.List;

//Adapter deve extender recyclerView
public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    //construtor recebe List<Postagem>
    public PostagemAdapter(List<Postagem> post) {

        this.postagens = post;
    }

    @NonNull
    /*
    * Para a exibição do CardView precisamos inflar o layout.
    * Para cada item do RecyclerView montaremos um CardView
    * No onCreateViewHolder vamos retornar a view baseada no xml,
    * vamos converter o xml em uma view e retorna-la
    * */
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.postagem_detalhe, viewGroup, false);

        //retorna uma instancia da classe MyViewHolder
        return new MyViewHolder(itemLista);
    }

    /*
    * Faz a exibição dos itens
    * o "myViewHolder" é o objeto que será retornado aqui e "i" é a podição desse objeto
    * */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        //recuperando as postagens
        Postagem postagem =  postagens.get( i );

        myViewHolder.textNome.setText(postagem.getNome());
        myViewHolder.textPostagem.setText(postagem.getPostagem());
        myViewHolder.imagePostagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textNome;
        private TextView textPostagem;
        private ImageView imagePostagem;

        //contrutor para o MyViewHolder
        //A classe recebe um itemView do tipo View
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textNomeId);
            textPostagem = itemView.findViewById(R.id.textPostagemId);
            imagePostagem = itemView.findViewById(R.id.imagePostagemId);

        }
    }


}
