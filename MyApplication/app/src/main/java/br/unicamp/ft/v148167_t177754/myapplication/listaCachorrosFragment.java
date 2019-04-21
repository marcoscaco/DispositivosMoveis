package br.unicamp.ft.v148167_t177754.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaCachorrosFragment extends Fragment {

    RecyclerView listaCachorrosRecycleview;
    private List<Dog> dogs;
    private ArrayList<String> racas;

    public listaCachorrosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cachorros, container, false);
        //recycleview que carrega a lista de alunos
        listaCachorrosRecycleview = (RecyclerView) view.findViewById(R.id.recycleViewListaCachorros);
        //layout para a recycle view de lista de dogs proximos
        LinearLayoutManager lim = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);


        listaCachorrosRecycleview.setLayoutManager(lim);

        dogs = getDogs();

        racas = new ArrayList<String>();
         racas = getArguments().getStringArrayList("racas");


        listaCachorrosRecycleViewAdapter adapter = new listaCachorrosRecycleViewAdapter(dogs, false, racas);
        listaCachorrosRecycleview.setAdapter(adapter);

        return view;
    }

    public void setDogs(List<Dog> dogs){
        this.dogs = dogs;
    }

    public List<Dog> getDogs(){
        return dogs;
    }

}
