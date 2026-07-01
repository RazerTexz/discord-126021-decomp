package androidx.core.view;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$id;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ViewCompat$Api21Impl {
    private ViewCompat$Api21Impl() {
    }

    public static void callCompatInsetAnimationCallback(@NonNull WindowInsets windowInsets, @NonNull View view) {
        View$OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener = (View$OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
        if (view$OnApplyWindowInsetsListener != null) {
            view$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return WindowInsetsCompat$Api21ReflectionHolder.getRootWindowInsets(view);
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build$VERSION.SDK_INT < 30) {
            view.setTag(R$id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewCompat$Api21Impl$1(view, onApplyWindowInsetsListener));
        }
    }
}
