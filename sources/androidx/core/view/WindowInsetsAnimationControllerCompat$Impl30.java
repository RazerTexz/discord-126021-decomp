package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsAnimationControllerCompat$Impl30 extends WindowInsetsAnimationControllerCompat$Impl {
    private final WindowInsetsAnimationController mController;

    public WindowInsetsAnimationControllerCompat$Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mController = windowInsetsAnimationController;
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public void finish(boolean z2) {
        this.mController.finish(z2);
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public float getCurrentAlpha() {
        return this.mController.getCurrentAlpha();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public float getCurrentFraction() {
        return this.mController.getCurrentFraction();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getCurrentInsets() {
        return Insets.toCompatInsets(this.mController.getCurrentInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getHiddenStateInsets() {
        return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getShownStateInsets() {
        return Insets.toCompatInsets(this.mController.getShownStateInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public int getTypes() {
        return this.mController.getTypes();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public boolean isCancelled() {
        return this.mController.isCancelled();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public boolean isFinished() {
        return this.mController.isFinished();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public boolean isReady() {
        return this.mController.isReady();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public void setInsetsAndAlpha(@Nullable Insets insets, float f, float f2) {
        this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
    }
}
