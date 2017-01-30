package com.example.leokallo.helloworld;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RistiNolla extends AppCompatActivity implements PeliLoppuiDialogFragment.PeliLoppuiDialogListener {

    private Logiikka logiikka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ristinolla);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        this.logiikka = new Logiikka();
        setContentView(R.layout.activity_ristinolla);
    }

    public void peliSiirto(View view) {
        Button button = (Button)view;
        int id = button.getId();
        String resName = getResources().getResourceEntryName(id);
        button.setTextSize(48);
        button.setText(logiikka.peliSiirto(new Koordinaatti(resName)));
        if (logiikka.peliPaattyi()) {
            ilmoitaTulos();
        }
    }

    public void ilmoitaTulos() {
        FragmentManager fm = getFragmentManager();
        DialogFragment dialog = new PeliLoppuiDialogFragment();
        Bundle args = new Bundle();
        args.putString("pelinTulos", logiikka.getPelinTulos());
        dialog.setArguments(args);
        dialog.show(fm, "PeliLoppuiDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        onStart();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        super.finish();
        System.out.println("lopeta peli");
    }
}
