package es.iesnervion.atellez.ficherosbasicos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String fileName = "ejemplo";
        String txtIntroducido;
        txtIntroducido = editText.getText().toString();
        Toast toast1 = Toast.makeText(getApplicationContext(), "se supone que sa guardao", Toast.LENGTH_SHORT);
        File file;

        FileOutputStream outputStream;
        try {
            file = new File(getCacheDir(),fileName);
            outputStream = new FileOutputStream(file);
            outputStream.write(txtIntroducido.getBytes());
            outputStream.close();

            toast1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
