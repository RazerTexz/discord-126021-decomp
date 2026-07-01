package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import b.d.b.a.a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class WindowInsetsCompat$Api21ReflectionHolder {
    private static Field sContentInsets;
    private static boolean sReflectionSucceeded;
    private static Field sStableInsets;
    private static Field sViewAttachInfoField;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            sViewAttachInfoField = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            sStableInsets = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            sContentInsets = declaredField3;
            declaredField3.setAccessible(true);
            sReflectionSucceeded = true;
        } catch (ReflectiveOperationException e) {
            StringBuilder sbU = a.U("Failed to get visible insets from AttachInfo ");
            sbU.append(e.getMessage());
            Log.w("WindowInsetsCompat", sbU.toString(), e);
        }
    }

    private WindowInsetsCompat$Api21ReflectionHolder() {
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        if (sReflectionSucceeded && view.isAttachedToWindow()) {
            try {
                Object obj = sViewAttachInfoField.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) sStableInsets.get(obj);
                    Rect rect2 = (Rect) sContentInsets.get(obj);
                    if (rect != null && rect2 != null) {
                        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat$Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                        windowInsetsCompatBuild.setRootWindowInsets(windowInsetsCompatBuild);
                        windowInsetsCompatBuild.copyRootViewBounds(view.getRootView());
                        return windowInsetsCompatBuild;
                    }
                }
            } catch (IllegalAccessException e) {
                StringBuilder sbU = a.U("Failed to get insets from AttachInfo. ");
                sbU.append(e.getMessage());
                Log.w("WindowInsetsCompat", sbU.toString(), e);
            }
        }
        return null;
    }
}
