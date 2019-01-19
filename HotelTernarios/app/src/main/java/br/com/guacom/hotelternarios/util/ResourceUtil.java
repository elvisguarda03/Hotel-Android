package br.com.guacom.hotelternarios.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.guacom.hotelternarios.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";
    public static final String INTERNATIONALIZATION = "string";

    public static Drawable getDrawable(Context context, String drawableInText) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableInText,
                DRAWABLE, context.getPackageName());//Pegando o pacote
        return resources.getDrawable(idDoDrawable);
    }

    public static String getString(Context context, String values) {
        Resources resources = context.getResources();
        int idOfField = resources.getIdentifier(values, INTERNATIONALIZATION, context.getPackageName());
        return resources.getString(idOfField);
    }
}
