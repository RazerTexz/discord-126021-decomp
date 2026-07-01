package androidx.core.view;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsAnimationControllerCompat$Impl {
    public void finish(boolean z2) {
    }

    public float getCurrentAlpha() {
        return 0.0f;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getCurrentFraction() {
        return 0.0f;
    }

    @NonNull
    public Insets getCurrentInsets() {
        return Insets.NONE;
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return Insets.NONE;
    }

    @NonNull
    public Insets getShownStateInsets() {
        return Insets.NONE;
    }

    public int getTypes() {
        return 0;
    }

    public boolean isCancelled() {
        return true;
    }

    public boolean isFinished() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
    }
}
