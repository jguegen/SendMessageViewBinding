package com.juanlugg8.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.juanlugg8.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.juanlugg8.sendmessageviewbinding.model.data.Message;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding binding;
    private Message message;
public  static  final String TAG = "ViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();

        //EJEMPLO 2: Con parcelable
        message = bundle.getParcelable(Message.KEY);

        initiliceView();
    }

    /**
     * Método que inicializa todas las vistas a widgets de la interfaz o del Layout
     */
    private void initiliceView() {

        binding.tvUserInfo.setText("La persona "+message.getSender().getName() + " " + message.getSender().getSurname() + " con DNI: " + message.getSender().getDni() + " te manda el mensaje:");
        binding.tvMessage.setText(message.getContent());
    }

    //region MÉTODOS DEL CICLO DE LA VIDA DE ACTIVITY
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ViewActivity -> onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"ViewActivity -> onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ViewActivity -> onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG,"ViewActivity -> onDestroy()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Se ha iniciado la Activity ViewActivity", Toast.LENGTH_SHORT).show();
    }
    //endregion
}