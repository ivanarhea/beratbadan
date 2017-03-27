package id.sch.smktelkom_mlg.learn.appberatbadan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    Button btncek, btnexit, btnclear;
    EditText editnama, edittinggi, editberat, hasilideal, hasilket1, hasilket2;
    RadioButton rdblaki, rdbperempuan;
    RadioGroup radioGroup;
    int h1,ti,bt;
    String temp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncek = (Button)findViewById(R.id.btncek);
        btnclear = (Button)findViewById(R.id.btnclear);
        btnexit = (Button)findViewById(R.id.btnexit);
        editnama = (EditText) findViewById(R.id.editnama);
        edittinggi = (EditText) findViewById(R.id.edittinggi);
        editberat = (EditText) findViewById(R.id.editberat);
        hasilideal = (EditText) findViewById(R.id.hasiledeal);
        hasilket1 = (EditText) findViewById(R.id.hasilket1);
        hasilket2 = (EditText) findViewById(R.id.hasilket2);
        rdblaki = (RadioButton) findViewById(R.id.rdblaki);
        rdbperempuan = (RadioButton) findViewById(R.id.rdbperempuan);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        btncek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { proses(); }

            private void proses() {
            int ti = Integer.parseInt(String.valueOf(edittinggi.getText()));
            int bt = Integer.parseInt(String.valueOf(editberat.getText()));

            if (rdblaki.isSelected()) {
                h1 = (ti - 100);
            } else if (rdbperempuan.isSelected()){
                h1 = (ti-104);
            }
            temp = Integer.toString(h1);

            if (h1 < bt){
                hasilideal.setText("Berat badan ideal anda" +temp);
                hasilket1.setText("Maaf" + editnama.getText() + " , Sepertinya anda Overweight");
                hasilket2.setText("Banyaklah berolahraga hidari makanan berkolestrol");
            } else if (h1 > bt) {
                hasilideal.setText("Berat badan ideal anda" +temp);
                hasilket1.setText("Maaf" + editnama.getText() + " , Sepertinya anda Underweight");
                hasilket2.setText("Banyaklah mengkonsumsi makanan yang berkarbohidrat");
            } else {
                hasilideal.setText("Berat badan ideal anda" +temp);
                hasilket1.setText("Maaf" + editnama.getText() + " , Berat badan anda sudah ideal");
                hasilket2.setText("Lanjutkan pola makan teratur dan gaya hidup sehat");
            }
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.exit(0);
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editnama.setText("");
                edittinggi.setText("");
                editberat.setText("");
                hasilideal.setText("");
                hasilket1.setText("");
                hasilket2.setText("");
                radioGroup.clearCheck();

            }
        });
    }
}
