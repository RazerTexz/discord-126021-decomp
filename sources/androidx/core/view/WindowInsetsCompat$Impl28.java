package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class WindowInsetsCompat$Impl28 extends WindowInsetsCompat$Impl21 {
    public WindowInsetsCompat$Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat$Impl28)) {
            return false;
        }
        WindowInsetsCompat$Impl28 windowInsetsCompat$Impl28 = (WindowInsetsCompat$Impl28) obj;
        return Objects.equals(this.mPlatformInsets, windowInsetsCompat$Impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, windowInsetsCompat$Impl28.mRootViewVisibleInsets);
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    public int hashCode() {
        return this.mPlatformInsets.hashCode();
    }

    public WindowInsetsCompat$Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat$Impl28 windowInsetsCompat$Impl28) {
        super(windowInsetsCompat, windowInsetsCompat$Impl28);
    }
}
