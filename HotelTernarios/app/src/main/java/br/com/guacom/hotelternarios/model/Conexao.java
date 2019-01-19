package br.com.guacom.hotelternarios.model;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {
    private static FirebaseAuth mFirebaseAuth;
    private static FirebaseAuth.AuthStateListener mAuthStateListener;
    private static FirebaseUser mFirebaUser;

    private Conexao() {
    }

    public static FirebaseAuth getFirebaseAuth() {
        //Se não houver usuário preciso cria-lo
        if(mFirebaseAuth == null) {
            startFirebase();
        }
        return mFirebaseAuth;
    }

    private static void startFirebase() {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    mFirebaUser = user;
                }
            }
        };
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
    public static FirebaseUser getmFirebaUser() {
        return mFirebaUser;
    }
    public static void logOut() {
        mFirebaseAuth.signOut();
    }
}
