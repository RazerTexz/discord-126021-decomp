package androidx.core.view;

import android.os.Build$VERSION;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final WindowInsetsAnimationControllerCompat$Impl mImpl;

    public WindowInsetsAnimationControllerCompat() {
        if (Build$VERSION.SDK_INT < 30) {
            this.mImpl = new WindowInsetsAnimationControllerCompat$Impl();
            return;
        }
        StringBuilder sbU = a.U("On API 30+, the constructor taking a ");
        sbU.append(WindowInsetsAnimationController.class.getSimpleName());
        sbU.append(" as parameter");
        throw new UnsupportedOperationException(sbU.toString());
    }

    public void finish(boolean z2) {
        this.mImpl.finish(z2);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    @NonNull
    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    @NonNull
    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }

    @RequiresApi(30)
    public WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new WindowInsetsAnimationControllerCompat$Impl30(windowInsetsAnimationController);
    }
}
