package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsCompat$Impl30 extends WindowInsetsCompat$Impl29 {

    @NonNull
    public static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

    public WindowInsetsCompat$Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    public final void copyRootViewBounds(@NonNull View view) {
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getInsets(int i) {
        return Insets.toCompatInsets(this.mPlatformInsets.getInsets(WindowInsetsCompat$TypeImpl30.toPlatformType(i)));
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(WindowInsetsCompat$TypeImpl30.toPlatformType(i)));
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    public boolean isVisible(int i) {
        return this.mPlatformInsets.isVisible(WindowInsetsCompat$TypeImpl30.toPlatformType(i));
    }

    public WindowInsetsCompat$Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat$Impl30 windowInsetsCompat$Impl30) {
        super(windowInsetsCompat, windowInsetsCompat$Impl30);
    }
}
