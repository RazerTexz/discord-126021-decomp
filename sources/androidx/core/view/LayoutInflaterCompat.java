package androidx.core.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater$Factory2;
import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater$Factory2 layoutInflater$Factory2) {
        if (!sCheckedField) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                StringBuilder sbU = a.U("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sbU.append(LayoutInflater.class.getName());
                sbU.append("; inflation may have unexpected results.");
                Log.e(TAG, sbU.toString(), e);
            }
            sCheckedField = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, layoutInflater$Factory2);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater$Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflaterCompat$Factory2Wrapper) {
            return ((LayoutInflaterCompat$Factory2Wrapper) factory).mDelegateFactory;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new LayoutInflaterCompat$Factory2Wrapper(layoutInflaterFactory) : null);
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater$Factory2 layoutInflater$Factory2) {
        layoutInflater.setFactory2(layoutInflater$Factory2);
    }
}
