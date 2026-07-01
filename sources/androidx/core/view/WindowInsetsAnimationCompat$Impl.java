package androidx.core.view;

import android.view.animation.Interpolator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsAnimationCompat$Impl {
    private float mAlpha;
    private final long mDurationMillis;
    private float mFraction;

    @Nullable
    private final Interpolator mInterpolator;
    private final int mTypeMask;

    public WindowInsetsAnimationCompat$Impl(int i, @Nullable Interpolator interpolator, long j) {
        this.mTypeMask = i;
        this.mInterpolator = interpolator;
        this.mDurationMillis = j;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public float getFraction() {
        return this.mFraction;
    }

    public float getInterpolatedFraction() {
        Interpolator interpolator = this.mInterpolator;
        return interpolator != null ? interpolator.getInterpolation(this.mFraction) : this.mFraction;
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getTypeMask() {
        return this.mTypeMask;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setFraction(float f) {
        this.mFraction = f;
    }
}
