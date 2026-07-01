package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class WindowInsetsControllerCompat$Impl23 extends WindowInsetsControllerCompat$Impl20 {
    public WindowInsetsControllerCompat$Impl23(@NonNull Window window, @Nullable View view) {
        super(window, view);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public boolean isAppearanceLightStatusBars() {
        return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setAppearanceLightStatusBars(boolean z2) {
        if (!z2) {
            unsetSystemUiFlag(8192);
            return;
        }
        unsetWindowFlag(67108864);
        setWindowFlag(Integer.MIN_VALUE);
        setSystemUiFlag(8192);
    }
}
