package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener implements View$OnApplyWindowInsetsListener {
    private static final int COMPAT_ANIMATION_DURATION = 160;
    public final WindowInsetsAnimationCompat$Callback mCallback;
    private WindowInsetsCompat mLastInsets;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener(@NonNull View view, @NonNull WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        this.mCallback = windowInsetsAnimationCompat$Callback;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        this.mLastInsets = rootWindowInsets != null ? new WindowInsetsCompat$Builder(rootWindowInsets).build() : null;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (!view.isLaidOut()) {
            this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        if (this.mLastInsets == null) {
            this.mLastInsets = ViewCompat.getRootWindowInsets(view);
        }
        if (this.mLastInsets == null) {
            this.mLastInsets = windowInsetsCompat;
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        WindowInsetsAnimationCompat$Callback callback = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        if (callback != null && Objects.equals(callback.mDispachedInsets, windowInsets)) {
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        int iBuildAnimationMask = WindowInsetsAnimationCompat$Impl21.buildAnimationMask(windowInsetsCompat, this.mLastInsets);
        if (iBuildAnimationMask == 0) {
            return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(iBuildAnimationMask, new DecelerateInterpolator(), 160L);
        windowInsetsAnimationCompat.setFraction(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
        WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompatComputeAnimationBounds = WindowInsetsAnimationCompat$Impl21.computeAnimationBounds(windowInsetsCompat, windowInsetsCompat2, iBuildAnimationMask);
        WindowInsetsAnimationCompat$Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsets, false);
        duration.addUpdateListener(new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1(this, windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, iBuildAnimationMask, view));
        duration.addListener(new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$2(this, windowInsetsAnimationCompat, view));
        OneShotPreDrawListener.add(view, new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3(this, view, windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompatComputeAnimationBounds, duration));
        this.mLastInsets = windowInsetsCompat;
        return WindowInsetsAnimationCompat$Impl21.forwardToViewIfNeeded(view, windowInsets);
    }
}
