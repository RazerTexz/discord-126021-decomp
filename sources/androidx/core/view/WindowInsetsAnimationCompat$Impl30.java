package androidx.core.view;

import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Bounds;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsAnimationCompat$Impl30 extends WindowInsetsAnimationCompat$Impl {

    @NonNull
    private final WindowInsetsAnimation mWrapped;

    public WindowInsetsAnimationCompat$Impl30(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.mWrapped = windowInsetsAnimation;
    }

    @NonNull
    public static WindowInsetsAnimation$Bounds createPlatformBounds(@NonNull WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        return new WindowInsetsAnimation$Bounds(windowInsetsAnimationCompat$BoundsCompat.getLowerBound().toPlatformInsets(), windowInsetsAnimationCompat$BoundsCompat.getUpperBound().toPlatformInsets());
    }

    @NonNull
    public static Insets getHigherBounds(@NonNull WindowInsetsAnimation$Bounds windowInsetsAnimation$Bounds) {
        return Insets.toCompatInsets(windowInsetsAnimation$Bounds.getUpperBound());
    }

    @NonNull
    public static Insets getLowerBounds(@NonNull WindowInsetsAnimation$Bounds windowInsetsAnimation$Bounds) {
        return Insets.toCompatInsets(windowInsetsAnimation$Bounds.getLowerBound());
    }

    public static void setCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        view.setWindowInsetsAnimationCallback(windowInsetsAnimationCompat$Callback != null ? new WindowInsetsAnimationCompat$Impl30$ProxyCallback(windowInsetsAnimationCompat$Callback) : null);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    public long getDurationMillis() {
        return this.mWrapped.getDurationMillis();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    public float getFraction() {
        return this.mWrapped.getFraction();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    public float getInterpolatedFraction() {
        return this.mWrapped.getInterpolatedFraction();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    @Nullable
    public Interpolator getInterpolator() {
        return this.mWrapped.getInterpolator();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    public int getTypeMask() {
        return this.mWrapped.getTypeMask();
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
    public void setFraction(float f) {
        this.mWrapped.setFraction(f);
    }

    public WindowInsetsAnimationCompat$Impl30(int i, Interpolator interpolator, long j) {
        this(new WindowInsetsAnimation(i, interpolator, j));
    }
}
