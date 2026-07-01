package androidx.core.view;

import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 29)
public class WindowInsetsCompat$BuilderImpl29 extends WindowInsetsCompat$BuilderImpl {
    public final WindowInsets$Builder mPlatBuilder;

    public WindowInsetsCompat$BuilderImpl29() {
        this.mPlatBuilder = new WindowInsets$Builder();
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    @NonNull
    public WindowInsetsCompat build() {
        applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
        windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setStableInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setSystemGestureInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setSystemWindowInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setTappableElementInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
    }

    public WindowInsetsCompat$BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets$Builder windowInsets$Builder;
        super(windowInsetsCompat);
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            windowInsets$Builder = new WindowInsets$Builder(windowInsets);
        } else {
            windowInsets$Builder = new WindowInsets$Builder();
        }
        this.mPlatBuilder = windowInsets$Builder;
    }
}
