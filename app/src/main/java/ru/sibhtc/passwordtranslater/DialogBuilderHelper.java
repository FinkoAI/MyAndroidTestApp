package ru.sibhtc.passwordtranslater;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Антон on 24.01.2016.
 **/
public final class DialogBuilderHelper {
    public static final int ABOUT_DIALOG  = 1;

    public static AlertDialog getDialog(Activity activity, int ID){
        AlertDialog result;

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        switch (ID){
            case ABOUT_DIALOG:
                builder.setTitle(R.string.dialog_about_title);
                builder.setMessage(R.string.dialog_about_message);
                builder.setCancelable(true);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Отпускает диалоговое окно
                    }
                });
                result = builder.create();
                break;
            default:
                result = null;
                break;
        }

        return result;
    }
}
