package androidx.core.content;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class ContextCompat$Api23Impl {
    private ContextCompat$Api23Impl() {
    }

    @DoNotInline
    public static int getColor(Context context, int i) {
        return context.getColor(i);
    }

    @DoNotInline
    public static ColorStateList getColorStateList(Context context, int i) {
        return context.getColorStateList(i);
    }

    @DoNotInline
    public static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    @DoNotInline
    public static String getSystemServiceName(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
