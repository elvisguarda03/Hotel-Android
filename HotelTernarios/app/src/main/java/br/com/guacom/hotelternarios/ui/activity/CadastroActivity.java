package br.com.guacom.hotelternarios.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.guacom.hotelternarios.model.Conexao;

public class CadastroActivity extends AppCompatActivity {
    private TextView tLogin;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnCadastrar;
    private FirebaseAuth auth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mDialog = new ProgressDialog(this);
        startComponent();
        click();
    }

    private void startComponent() {
        tLogin = findViewById(R.id.cadastro_textViewLogin);
        btnCadastrar = findViewById(R.id.cadastro_cadastrar);
        editEmail = findViewById(R.id.cadastro_email);
        editSenha = findViewById(R.id.cadastro_senha);
    }

    private void click() {
        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                mDialog.show();
                createUser(email, senha);
                finish();
            }
        });
    }

    private void createUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            alert("Cadastro efetuado com sucesso!");
                            Intent intent = new Intent(CadastroActivity.this, MenuActivity.class);
                            startActivity(intent);
                            mDialog.dismiss();
                            finish();
                            return;
                        }
                        alert("Erro de cadastro!");
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
