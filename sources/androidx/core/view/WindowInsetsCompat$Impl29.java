package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class WindowInsetsCompat$Impl29 extends WindowInsetsCompat$Impl28 {
    private Insets mMandatorySystemGestureInsets;
    private Insets mSystemGestureInsets;
    private Insets mTappableElementInsets;

    public WindowInsetsCompat$Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
        this.mSystemGestureInsets = null;
        this.mMandatorySystemGestureInsets = null;
        this.mTappableElementInsets = null;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        if (this.mMandatorySystemGestureInsets == null) {
            this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
        }
        return this.mMandatorySystemGestureInsets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getSystemGestureInsets() {
        if (this.mSystemGestureInsets == null) {
            this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
        }
        return this.mSystemGestureInsets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public Insets getTappableElementInsets() {
        if (this.mTappableElementInsets == null) {
            this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
        }
        return this.mTappableElementInsets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl20, androidx.core.view.WindowInsetsCompat$Impl
    @NonNull
    public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i, i2, i3, i4));
    }

    @Override // androidx.core.view.WindowInsetsCompat$Impl21, androidx.core.view.WindowInsetsCompat$Impl
    public void setStableInsets(@Nullable Insets insets) {
    }

    public WindowInsetsCompat$Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat$Impl29 windowInsetsCompat$Impl29) {
        super(windowInsetsCompat, windowInsetsCompat$Impl29);
        this.mSystemGestureInsets = null;
        this.mMandatorySystemGestureInsets = null;
        this.mTappableElementInsets = null;
    }
}
