package androidx.core.view;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class ViewCompat$Api30Impl {
    private ViewCompat$Api30Impl() {
    }

    @Nullable
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
        }
        return null;
    }
}
