package com.example.leokallo.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by leokallo on 20.10.2016.
 */

public class PeliLoppuiDialogFragment extends DialogFragment {

    // Rajapinta, joka mahdollistaa viestien välittämisen aktiviteetille
    public interface PeliLoppuiDialogListener {
        // parametrina välitetään dialogi aktiviteetille
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Rajapinnan instanssi, jonka kautta välitetään painallukset
    PeliLoppuiDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // varmistetaan, että isäntäaktiviteetti toteuttaa rajapinnan viestien vastaanottamiseksi
            mListener = (PeliLoppuiDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " tulee toteuttaa PeliLoppuiDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String pelinTulos = getArguments().getString("pelinTulos");
        builder.setMessage(pelinTulos)
                .setNegativeButton(R.string.new_game, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(PeliLoppuiDialogFragment.this);
                    }
                })
                .setPositiveButton(R.string.quit_game, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(PeliLoppuiDialogFragment.this);
                    }
                });
        return builder.create();
    }
}
