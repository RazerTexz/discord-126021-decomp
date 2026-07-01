package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class WindowInsetsControllerCompat$Impl26 extends WindowInsetsControllerCompat$Impl23 {
    public WindowInsetsControllerCompat$Impl26(@NonNull Window window, @Nullable View view) {
        super(window, view);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public boolean isAppearanceLightNavigationBars() {
        return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setAppearanceLightNavigationBars(boolean z2) {
        if (!z2) {
            unsetSystemUiFlag(16);
            return;
        }
        unsetWindowFlag(134217728);
        setWindowFlag(Integer.MIN_VALUE);
        setSystemUiFlag(16);
    }
}
