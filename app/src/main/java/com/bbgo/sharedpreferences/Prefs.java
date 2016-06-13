package com.bbgo.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by BBEIRIGO on 2016-06-12.
 */
public class Prefs {
    //Identificador do banco de dados destas preferências
    public static final String PREF_ID = "app";

    public static void setString(Context context, String chave, String valor){
        //Recupera um objeto SharedPreferences
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        //Objeto do tipo Editor usado para modificar valores em pref
        SharedPreferences.Editor editor = pref.edit();
        //Como na estrutura de dados Map, associa chave a valor
        editor.putString(chave,valor);
        //Método commit efetiva as alterações no banco de dados interno da aplicação
        editor.commit();
    }

    public static String getString(Context context, String chave){
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        //getString(chave, default value)
        String s = pref.getString(chave, "");
        return s;
    }
    public static void setInteger(Context context, String chave, int valor){
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(chave,valor);
        editor.commit();
    }

    public static Integer getInteger(Context context, String chave){
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        int i = pref.getInt(chave, 0);
        return i;
    }

    public static void remove(Context context, String chave){
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        //Remove a chave
        editor.remove(chave);
        //Remove todos valores salvos
        //editor.clear();
        //Efetua as modificações no banco
        editor.commit();
    }
}
