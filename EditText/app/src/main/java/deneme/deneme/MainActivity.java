package deneme.deneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editAd,editEmail,editTel,editCinsiyet,editYas;
    Button butonGonder;
    String email;
    String deger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Nesnlere erişim sağlanması için findviewbyid kullanıldı
        editAd = findViewById(R.id.editAd);
        editEmail = findViewById(R.id.editEmail);
        editTel = findViewById(R.id.editTel);
        editCinsiyet = findViewById(R.id.editCinsiyet);
        editYas = findViewById(R.id.editYas);
        butonGonder = findViewById(R.id.buttonGonder);


        //EditText e tıklandığında yapılacak işlemler
        editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){  //Eğer tıklama işlemi sonlanırsa bu işlem gerçekleşir
                 email = editEmail.getText().toString();
                    if (isValidEmail(email) != true){ //Email in valid olup olmadığı kontrol edildi
                        editEmail.setError("Geçersiz Email");
                    }
            }
            }
        });

        //Yaş edittextine gelindiğinde boş bırakılması kontrol edildi
        editYas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus != true){

                   deger = editYas.getText().toString();
                   if (deger.isEmpty())
                       editYas.setError("Boş Bırakılamaz");
                }
            }
        });
        //Cinsiyet edittext inin boş olup olmadığı kontrol edildi
        editCinsiyet.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus != true){
                    deger = editCinsiyet.getText().toString();
                    if (deger.isEmpty())
                        editCinsiyet.setError("Boş Bırakılamaz");
                }
            }
        });

        //Tel edittextinin boş olup oladığı kontrol edildi.
        editTel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus != true){
                    deger = editTel.getText().toString();
                    if (deger.isEmpty())
                        editTel.setError("Boş Bırakılamaz");
                }
            }
        });

        //Ad edittext inin boş olup olmadığı kontrol edildi.
        editAd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus != true){
                    deger = editAd.getText().toString();
                    if (deger.isEmpty())
                        editAd.setError("Boş Bırakılamaz");
                }
            }
        });




        //Gönder butonuna basıldığında Toast Mesajı ekrana yazıldı
        butonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Formunuz Gönderildi", Toast.LENGTH_SHORT).show();
            }
        });


    }


    //Mail in Valid olup olmadığını kontrol eden kod parçası
    public boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            // e-posta formatı kontrol
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
