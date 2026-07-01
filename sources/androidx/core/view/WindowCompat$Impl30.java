package androidx.core.view;

import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowCompat$Impl30 {
    private WindowCompat$Impl30() {
    }

    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window) {
        WindowInsetsController insetsController = window.getInsetsController();
        if (insetsController != null) {
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(insetsController);
        }
        return null;
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z2) {
        window.setDecorFitsSystemWindows(z2);
    }
}
