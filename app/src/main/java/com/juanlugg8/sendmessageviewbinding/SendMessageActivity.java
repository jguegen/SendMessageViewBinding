package com.juanlugg8.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.juanlugg8.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.juanlugg8.sendmessageviewbinding.model.data.Message;
import com.juanlugg8.sendmessageviewbinding.model.data.Person;

public class SendMessageActivity extends AppCompatActivity {

    private ActivitySendMessageBinding binding;
    public static final String TAG ="SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //OPCIÓN 3: Expresión Lambda para implementar el evento onClick()
        binding.fab.setOnClickListener(view -> {
            sendMessage();
        }
        );

        Log.d(TAG,"SendMessageActivity -> onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.menu_aboutas) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//region MÉTODOS DEL CICLO DE LA VIDA DE ACTIVITY
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessageActivity -> onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessageActivity -> onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SendMessageActivity -> onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessageActivity -> onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG,"SendMessageActivity -> onDestroy()");
    }
    //endregion

    /**
     * Método que construye el mensaje y lo envia a otra Activity
     */
    private void sendMessage() {
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();
        //bundle.putString("user","El usuario Juan Luis Guerra Gennich te manda el siguiente mensaje:");
        //bundle.putString("message","Hoy tapeamos después de clase :)");
        Person persone = new Person("Juan Luis", "Guerra Gennich", "1234");
        Person persond = new Person("Jose Luiz", "Benitez", "5678");
        //bundle.putParcelable(Person.KEY,persone);
        Message message = new Message(1,binding.edMessage.getText().toString(),persone,persond);
        //OPCIÓN 1
        //bundle.putSerializable(Message.KEY,message);

        //OPCIÓN 2
        bundle.putParcelable(Message.KEY,message);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * OPCIÓN 1: Se crea una clase que implementa la interfaz View.OnClickListener
     */
    class SendMessageOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast.makeText(SendMessageActivity.this, "Se ha pulsado sobre el botón enviar", Toast.LENGTH_SHORT).show();
        }
    }
}