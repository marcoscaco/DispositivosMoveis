package com.example.genericasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GenericAsyncTask<Object, Integer, Boolean> instancia3GenericAsyncTask =
                new GenericAsyncTask<>();
        instancia3GenericAsyncTask.execute(Boolean.FALSE, Integer.valueOf(500), new String("String"));
    }

    class GenericAsyncTask<T,E, Y> extends AsyncTask<T, E, Y>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"funcionando com PreExecute de: " + this
                    .getClass().getSimpleName(), Toast.LENGTH_LONG).show();
        }

        /**
         *  Waste some times in Background to show MULTI THREAD USAGE
         *
         * @return
         *  This returns null because we don't know the TYPE of doInBackground on this
         */
        @Override
        protected Y doInBackground(T... ts) {
            // wasting time on BG
            wastTime(ts);

            // notify main thread
            publishProgress();

            // must return null because we don't know the TYPE of this do InBackground
            return null;
        }

        @Override
        protected void onProgressUpdate(E... values) {
            Toast.makeText(MainActivity.this,"funcionando com ProgressUpdate: " + this
                    .getClass().getSimpleName(), Toast.LENGTH_LONG).show();        }
    }

    /**
     * Waste some time with 50000 prints of the obs Class name
     *
     * @param obs
     *
     */
    void wastTime(Object[] obs){
        for (int i = 0; i <= 50000; i++ ){
            for (Object ob : obs){
                System.out.println(ob.getClass().getSimpleName());
            }
        }

    }
}