package br.unicamp.ft.v148167_t177754.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class perfildogsFragment extends Fragment {

    private ImageView FotoCachorro;
    private EditText NomeCachorro;
    private EditText SobreCachorro;
    private EditText IdadeCachorro;
    private Spinner SexoCachorro;
    private Spinner RacaCachorro;
    private View view;
    private List<Dog> dogs;
    boolean editMode;
    ArrayList<String> racasArrayList;

    public perfildogsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_perfil_dogs, container, false);
        }


        FotoCachorro = view.findViewById(R.id.imageViewDogAvatar);
        NomeCachorro = view.findViewById(R.id.editTextDogNome);
        SobreCachorro = view.findViewById(R.id.editTextDogOverview);
        SexoCachorro = view.findViewById(R.id.spinnerDogSex);
        RacaCachorro = view.findViewById(R.id.spinnerRacas);
        IdadeCachorro = view.findViewById((R.id.editTextDogAge));

        dogs = getDogs();
        FotoCachorro.setImageResource(dogs.get(0).getPicture());
        NomeCachorro.setText(dogs.get(0).getName());
        SobreCachorro.setText(dogs.get(0).getOverview());
        IdadeCachorro.setText(dogs.get(0).getAge());

        racasArrayList = new ArrayList<String>();
        racasArrayList = getArguments().getStringArrayList("racas");
        RacaCachorro.setSelection(racasArrayList.indexOf(dogs.get(0).getRaca()));
        SexoCachorro.setSelection(racasArrayList.indexOf(dogs.get(0).getSex()));

        return view;
    }

    public void setDogs(List<Dog> dogs){
        this.dogs = dogs;
    }

    public List<Dog> getDogs(){
        return dogs;
    }

}
