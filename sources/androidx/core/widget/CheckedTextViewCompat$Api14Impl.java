package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class CheckedTextViewCompat$Api14Impl {
    private static Field sCheckMarkDrawableField;
    private static boolean sResolved;

    private CheckedTextViewCompat$Api14Impl() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
        if (!sResolved) {
            try {
                Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                sCheckMarkDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CheckedTextViewCompat", "Failed to retrieve mCheckMarkDrawable field", e);
            }
            sResolved = true;
        }
        Field field = sCheckMarkDrawableField;
        if (field != null) {
            try {
                return (Drawable) field.get(checkedTextView);
            } catch (IllegalAccessException e2) {
                Log.i("CheckedTextViewCompat", "Failed to get check mark drawable via reflection", e2);
                sCheckMarkDrawableField = null;
            }
        }
        return null;
    }
}
