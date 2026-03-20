
package com.example.gymcontroltcc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ViewHolder>{

    private List<Aluno> lista;
    private List<Aluno> listaCompleta;

    public AlunoAdapter(List<Aluno> alunos){
        this.lista = alunos;
        this.listaCompleta = new ArrayList<>(alunos);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome;

        public ViewHolder(View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomeAluno);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aluno,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        holder.nome.setText(lista.get(position).nome);
    }

    @Override
    public int getItemCount(){
        return lista.size();
    }

    public void filtrar(String texto){
        lista.clear();

        if(texto.isEmpty()){
            lista.addAll(listaCompleta);
        }else{
            texto = texto.toLowerCase();
            for(Aluno a : listaCompleta){
                if(a.nome.toLowerCase().contains(texto)){
                    lista.add(a);
                }
            }
        }

        notifyDataSetChanged();
    }
}
