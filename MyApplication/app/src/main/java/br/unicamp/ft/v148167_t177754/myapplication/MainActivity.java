package br.unicamp.ft.v148167_t177754.myapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.telecom.ConnectionRequest;
import android.util.Log;
import android.widget.ImageView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static br.unicamp.ft.v148167_t177754.myapplication.perfildogsFragment.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    //Gerenciador de fragmentos!
    FragmentManager fragmentManager;
    // Bundle para troca de informaçoes
    private Bundle bundle;

    //dados array com dados de racas
    private ArrayList<String> racas;


    ImageView imageviewAvatar;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // preenche dados array com dados de racas
        racas = new ArrayList<String>();
        racas = new ArrayList<String>(Arrays.asList((getResources().getStringArray(R.array.racas))));


        //bundle
        bundle = new Bundle();
        bundle.putStringArrayList("racas", racas);

        // fragmentaMnager
        fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = new MainFragment();
        ReplaceFrag(mainFragment, "fragMain", bundle);



    }
    // retorna dados array com dados de racas
    public ArrayList<String> getRacas(){
        return this.racas;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            MainFragment mainFragment = new MainFragment();
            ReplaceFrag(mainFragment, "fragMain", bundle);
        } else if (id == R.id.nav_locateDogs) {

            // prenche lista de dogs com dogs proximos que batem descricao
            // array com dogs proximos
            ArrayList<Dog> dogsProximos;
            dogsProximos = new ArrayList<>();
            dogsProximos.add(new Dog(R.drawable.avatardog, "Um cachorro muito fofo", "3 Anos", "Macho", "Poodle", "Fofinho"));
            dogsProximos.add(new Dog(R.drawable.avatardog, "Um cachorro muito fofo Rottweller", "3 Anos", "Fêmea", "Rottweiler", "Fofinho"));

            Bundle locateDogsBundle = new Bundle();
            locateDogsBundle.putStringArrayList("racas", racas);
            //locateDogsBundle.putSerializable("dogsProximos", (Serializable) new Dog(R.drawable.avatardog, "Um cachorro muito fofo", "3 Anos", "Macho", "Poodle", "Fofinho"));

            locateFragment locateFragment = new locateFragment();
            ReplaceFrag(locateFragment, "locateFrag", locateDogsBundle);
        } else if (id == R.id.nav_profileUser) {
            Bundle profileUSerBundle = new Bundle();
            perfilFragment fragment = new perfilFragment();
            ReplaceFrag(fragment, "fragPerfil", profileUSerBundle);
        } else if (id == R.id.nav_newDog) {
            Bundle newDogBundle = new Bundle();
            perfildogsFragment fragDogs = new perfildogsFragment();
            // Lista de 1 cachorro generico, inicia o fragmento em modo edit
            ArrayList<Dog> dogenerico;
            dogenerico = new ArrayList<>();
            dogenerico.add(new Dog(R.drawable.avatardog, "", "? Anos", "", "", ""));

            fragDogs.setDogs(dogenerico);
            ReplaceFrag(fragDogs, "fragDogs", newDogBundle);
        } else if (id == R.id.lista){
            Bundle listaDogsBundle = new Bundle();
            listaDogsBundle.putStringArrayList("racas", racas);
            Toast toast = Toast.makeText(getBaseContext(), "toast", Toast.LENGTH_LONG);
            toast.show();
            listaCachorrosFragment listaCachorrosFragment = new listaCachorrosFragment();
            // Lista de Cachorros que estão proximos
            ArrayList<Dog> dogsProximos;
            dogsProximos = new ArrayList<>();
            dogsProximos.add(new Dog(R.drawable.avatardog, "Um cachorro muito fofo Rottweller", "3 Anos", "Fêmea", "Rottweiler", "Fofinho"));
            dogsProximos.add(new Dog(R.drawable.avatardog, "Um cachorro muito fofo Rottweller", "3 Anos", "Fêmea", "Rottweiler", "Fofinho"));
            dogsProximos.add(new Dog(R.drawable.avatardog, "Um cachorro muito fofo Rottweller", "3 Anos", "Fêmea", "Rottweiler", "Fofinho"));

            listaCachorrosFragment.setDogs(dogsProximos);
            ReplaceFrag(listaCachorrosFragment, "listadogsFrag", listaDogsBundle);
        };

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

// metodos para setar imagem

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    imageviewAvatar.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageviewAvatar.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    private void  requestMultiplePermissions(){
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    // metodos para setar imagem


    // metodo para setar o fragmento
    private void ReplaceFrag(Fragment frag, String tag, Bundle bundle) {
        frag.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(fragmentManager.findFragmentByTag(tag) != null){
            fragmentTransaction.replace(R.id.frameLayoutMain, fragmentManager.findFragmentByTag(tag), tag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else {
            fragmentTransaction.replace(R.id.frameLayoutMain, frag, tag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
    // metodo para setar fragmentos
}
