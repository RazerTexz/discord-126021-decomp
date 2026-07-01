package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R$id;
import androidx.core.graphics.Insets;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class WindowInsetsAnimationCompat$Impl21 extends WindowInsetsAnimationCompat$Impl {
    public WindowInsetsAnimationCompat$Impl21(int i, @Nullable Interpolator interpolator, long j) {
        super(i, interpolator, j);
    }

    @SuppressLint({"WrongConstant"})
    public static int buildAnimationMask(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2) {
        int i = 0;
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if (!windowInsetsCompat.getInsets(i2).equals(windowInsetsCompat2.getInsets(i2))) {
                i |= i2;
            }
        }
        return i;
    }

    @NonNull
    public static WindowInsetsAnimationCompat$BoundsCompat computeAnimationBounds(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2, int i) {
        Insets insets = windowInsetsCompat.getInsets(i);
        Insets insets2 = windowInsetsCompat2.getInsets(i);
        return new WindowInsetsAnimationCompat$BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
    }

    @NonNull
    private static View$OnApplyWindowInsetsListener createProxyListener(@NonNull View view, @NonNull WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        return new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener(view, windowInsetsAnimationCompat$Callback);
    }

    public static void dispatchOnEnd(@NonNull View view, @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        WindowInsetsAnimationCompat$Callback callback = getCallback(view);
        if (callback != null) {
            callback.onEnd(windowInsetsAnimationCompat);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                dispatchOnEnd(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
            }
        }
    }

    public static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z2) {
        WindowInsetsAnimationCompat$Callback callback = getCallback(view);
        if (callback != null) {
            callback.mDispachedInsets = windowInsets;
            if (!z2) {
                callback.onPrepare(windowInsetsAnimationCompat);
                z2 = callback.getDispatchMode() == 0;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                dispatchOnPrepare(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z2);
            }
        }
    }

    public static void dispatchOnProgress(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
        WindowInsetsAnimationCompat$Callback callback = getCallback(view);
        if (callback != null) {
            windowInsetsCompat = callback.onProgress(windowInsetsCompat, list);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                dispatchOnProgress(viewGroup.getChildAt(i), windowInsetsCompat, list);
            }
        }
    }

    public static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        WindowInsetsAnimationCompat$Callback callback = getCallback(view);
        if (callback != null) {
            callback.onStart(windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                dispatchOnStart(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat);
            }
        }
    }

    @NonNull
    public static WindowInsets forwardToViewIfNeeded(@NonNull View view, @NonNull WindowInsets windowInsets) {
        return view.getTag(R$id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    @Nullable
    public static WindowInsetsAnimationCompat$Callback getCallback(View view) {
        Object tag = view.getTag(R$id.tag_window_insets_animation_callback);
        if (tag instanceof WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener) {
            return ((WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener) tag).mCallback;
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public static WindowInsetsCompat interpolateInsets(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int i) {
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder(windowInsetsCompat);
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) == 0) {
                windowInsetsCompat$Builder.setInsets(i2, windowInsetsCompat.getInsets(i2));
            } else {
                Insets insets = windowInsetsCompat.getInsets(i2);
                Insets insets2 = windowInsetsCompat2.getInsets(i2);
                float f2 = 1.0f - f;
                windowInsetsCompat$Builder.setInsets(i2, WindowInsetsCompat.insetInsets(insets, (int) (((double) ((insets.left - insets2.left) * f2)) + 0.5d), (int) (((double) ((insets.top - insets2.top) * f2)) + 0.5d), (int) (((double) ((insets.right - insets2.right) * f2)) + 0.5d), (int) (((double) ((insets.bottom - insets2.bottom) * f2)) + 0.5d)));
            }
        }
        return windowInsetsCompat$Builder.build();
    }

    public static void setCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        Object tag = view.getTag(R$id.tag_on_apply_window_listener);
        if (windowInsetsAnimationCompat$Callback == null) {
            view.setTag(R$id.tag_window_insets_animation_callback, null);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            return;
        }
        View$OnApplyWindowInsetsListener view$OnApplyWindowInsetsListenerCreateProxyListener = createProxyListener(view, windowInsetsAnimationCompat$Callback);
        view.setTag(R$id.tag_window_insets_animation_callback, view$OnApplyWindowInsetsListenerCreateProxyListener);
        if (tag == null) {
            view.setOnApplyWindowInsetsListener(view$OnApplyWindowInsetsListenerCreateProxyListener);
        }
    }
}
