package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private WindowInsetsAnimationCompat$Impl mImpl;

    public WindowInsetsAnimationCompat(int i, @Nullable Interpolator interpolator, long j) {
        if (Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new WindowInsetsAnimationCompat$Impl30(i, interpolator, j);
        } else {
            this.mImpl = new WindowInsetsAnimationCompat$Impl21(i, interpolator, j);
        }
    }

    public static void setCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        if (Build$VERSION.SDK_INT >= 30) {
            WindowInsetsAnimationCompat$Impl30.setCallback(view, windowInsetsAnimationCompat$Callback);
        } else {
            WindowInsetsAnimationCompat$Impl21.setCallback(view, windowInsetsAnimationCompat$Callback);
        }
    }

    @RequiresApi(30)
    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mImpl.setAlpha(f);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mImpl.setFraction(f);
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new WindowInsetsAnimationCompat$Impl30(windowInsetsAnimation);
        }
    }
}
