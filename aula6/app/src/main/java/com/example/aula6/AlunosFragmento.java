package com.example.aula6;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aula6.interfaces.OnBiografiaRequest;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlunosFragmento extends Fragment {

    private RecyclerView alunosView;
    private AlunoAdapter alunosAdapter;

    private View view;

    private OnBiografiaRequest onBiografiaRequest;
    public void setOnBiografiaRequest(OnBiografiaRequest onBiografiaRequest) {
        this.onBiografiaRequest = onBiografiaRequest;
    }

    public AlunosFragmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_alunos_fragmento, container, false);
            alunosView = view.findViewById(R.id.alunosView);
            alunosView.setLayoutManager(new LinearLayoutManager(getContext()));

            alunosAdapter = new AlunoAdapter(new ArrayList(Arrays.asList(Alunos.alunos)));

            alunosView.setAdapter(alunosAdapter);


            ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    final int position = viewHolder.getAdapterPosition();
                    if (direction == ItemTouchHelper.LEFT){
                        alunosAdapter.notifyItemRemoved(position);
                        alunosAdapter.remove(position);
                    }
                }
            };

            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
            itemTouchHelper.attachToRecyclerView(alunosView);

            alunosAdapter.setMyOnItemClickListener(new AlunoAdapter.MyOnItemClickListener() {
                                                       @Override
                                                       public void MyOnItemClick(String nome) {
                                                           Toast toast = Toast.makeText(getContext(), "Aluno: " + nome, Toast.LENGTH_LONG);
                                                           toast.show();
                                                       }
                                                   }
            );
            alunosAdapter.setMyOnItemLongClickListener(new AlunoAdapter.MyOnItemLongClickListener() {
                @Override
                public void MyOnItemLongClick(int position) {
                    if (onBiografiaRequest != null){
                        onBiografiaRequest.onRequest(position);
                    }
                }
            });

        }
        return view;
    }

}
