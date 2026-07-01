package androidx.core.view;

import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsCompat$Builder {
    private final WindowInsetsCompat$BuilderImpl mImpl;

    public WindowInsetsCompat$Builder() {
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new WindowInsetsCompat$BuilderImpl30();
        } else if (i >= 29) {
            this.mImpl = new WindowInsetsCompat$BuilderImpl29();
        } else {
            this.mImpl = new WindowInsetsCompat$BuilderImpl20();
        }
    }

    @NonNull
    public WindowInsetsCompat build() {
        return this.mImpl.build();
    }

    @NonNull
    public WindowInsetsCompat$Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        this.mImpl.setDisplayCutout(displayCutoutCompat);
        return this;
    }

    @NonNull
    public WindowInsetsCompat$Builder setInsets(int i, @NonNull Insets insets) {
        this.mImpl.setInsets(i, insets);
        return this;
    }

    @NonNull
    public WindowInsetsCompat$Builder setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
        this.mImpl.setInsetsIgnoringVisibility(i, insets);
        return this;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat$Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
        this.mImpl.setMandatorySystemGestureInsets(insets);
        return this;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat$Builder setStableInsets(@NonNull Insets insets) {
        this.mImpl.setStableInsets(insets);
        return this;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat$Builder setSystemGestureInsets(@NonNull Insets insets) {
        this.mImpl.setSystemGestureInsets(insets);
        return this;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat$Builder setSystemWindowInsets(@NonNull Insets insets) {
        this.mImpl.setSystemWindowInsets(insets);
        return this;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat$Builder setTappableElementInsets(@NonNull Insets insets) {
        this.mImpl.setTappableElementInsets(insets);
        return this;
    }

    @NonNull
    public WindowInsetsCompat$Builder setVisible(int i, boolean z2) {
        this.mImpl.setVisible(i, z2);
        return this;
    }

    public WindowInsetsCompat$Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new WindowInsetsCompat$BuilderImpl30(windowInsetsCompat);
        } else if (i >= 29) {
            this.mImpl = new WindowInsetsCompat$BuilderImpl29(windowInsetsCompat);
        } else {
            this.mImpl = new WindowInsetsCompat$BuilderImpl20(windowInsetsCompat);
        }
    }
}
