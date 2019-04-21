package br.unicamp.ft.v148167_t177754.myapplication;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class listaCachorrosRecycleViewAdapter extends RecyclerView.Adapter<listaCachorrosRecycleViewAdapter.DogViewHolder> {

    List<Dog> dogs;
    boolean editMode;
    ArrayList<String> racasArrayList;

    public listaCachorrosRecycleViewAdapter(List<Dog> dogs, boolean editMode, ArrayList<String> racasArrayList){
        this.dogs = dogs;
        this.editMode = editMode;
        this.racasArrayList = racasArrayList;
    }

    public class  DogViewHolder extends RecyclerView.ViewHolder{
        ImageView FotoCachorro;
        EditText NomeCachorro;
        EditText SobreCachorro;
        EditText IdadeCachorro;
        Spinner SexoCachorro;
        Spinner RacaCachorro;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            FotoCachorro = itemView.findViewById(R.id.imageViewDogAvatar);
            NomeCachorro = itemView.findViewById(R.id.editTextDogNome);
            SobreCachorro = itemView.findViewById(R.id.editTextDogOverview);
            SexoCachorro = itemView.findViewById(R.id.spinnerDogSex);
            RacaCachorro = itemView.findViewById(R.id.spinnerRacas);
            IdadeCachorro = itemView.findViewById((R.id.editTextDogAge));
        }
    }

    @NonNull
    @Override
    public listaCachorrosRecycleViewAdapter.DogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // infla o layout que cada item do Recycle view vai usar
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_perfil_dogs, viewGroup, false);
        // view holder para aquele item da lista
        DogViewHolder viewHolder = new DogViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull listaCachorrosRecycleViewAdapter.DogViewHolder dogViewHolder, int i) {
        dogViewHolder.FotoCachorro.setImageResource(dogs.get(i).getPicture());
        dogViewHolder.NomeCachorro.setText(dogs.get(i).getName());
        dogViewHolder.SobreCachorro.setText(dogs.get(i).getOverview());
        dogViewHolder.IdadeCachorro.setText(dogs.get(i).getAge());
        dogViewHolder.RacaCachorro.setSelection(racasArrayList.indexOf(dogs.get(i).getRaca()));
        dogViewHolder.SexoCachorro.setSelection(racasArrayList.indexOf(dogs.get(i).getSex()));


        //inverter aqui condicao
        if (this.editMode) {
            FragUtilities fragUtilities = new FragUtilities();
            fragUtilities.disableEditText(dogViewHolder.NomeCachorro);
            fragUtilities.disableEditText(dogViewHolder.IdadeCachorro);
            fragUtilities.disableEditText(dogViewHolder.SobreCachorro);
            fragUtilities.disableSpinner(dogViewHolder.RacaCachorro);
            fragUtilities.disableSpinner(dogViewHolder.SexoCachorro);
        }
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }

}
