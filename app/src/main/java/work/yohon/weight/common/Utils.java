package work.yohon.weight.common;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Utils {

    public static int getId(AppCompatActivity context, String name) {
        return context.getResources().getIdentifier(name, "id" , "work.yohon.weight");
    }

    public static View findViewId(AppCompatActivity context, String name) {
        return context.findViewById(getId(context, name));
    }

    public static int getLayout(AppCompatActivity context, String name) {
        return context.getResources().getIdentifier(name, "layout" , "work.yohon.weight");
    }

    public static boolean isNull(Object value) {
        return value == null;
    }
}
