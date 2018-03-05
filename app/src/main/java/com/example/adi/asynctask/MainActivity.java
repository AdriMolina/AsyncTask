package com.example.adi.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static com.example.adi.asynctask.R.id.time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time time = new time();
        time.execute();
    }
    //Funcion que hara que se el hilo se duerma cada segundo
    public void hilo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void ejecutar(){
        time time = new time();
        time.execute();

    }
    //clase que crea el hilo con que se trabajara en segundo plano
    public class time extends AsyncTask<Void, Integer,Boolean>{

        //metodo que trabaja en segundo plano
        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i=1; i<=3; i++){
                    hilo();
            }
            return true;
        }

        //Método que ejecuta cuando termina el tiempo

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            ejecutar();
            Toast.makeText(MainActivity.this, " cada dos segundos", Toast.LENGTH_SHORT).show();
        }
    }
}
