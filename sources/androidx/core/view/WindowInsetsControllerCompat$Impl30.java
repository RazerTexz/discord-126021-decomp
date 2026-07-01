package androidx.core.view;

import android.os.CancellationSignal;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsControllerCompat$Impl30 extends WindowInsetsControllerCompat$Impl {
    public final WindowInsetsControllerCompat mCompatController;
    public final WindowInsetsController mInsetsController;
    private final SimpleArrayMap<WindowInsetsControllerCompat$OnControllableInsetsChangedListener, WindowInsetsController$OnControllableInsetsChangedListener> mListeners;

    public WindowInsetsControllerCompat$Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this(window.getInsetsController(), windowInsetsControllerCompat);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void addOnControllableInsetsChangedListener(@NonNull WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        if (this.mListeners.containsKey(windowInsetsControllerCompat$OnControllableInsetsChangedListener)) {
            return;
        }
        WindowInsetsControllerCompat$Impl30$2 windowInsetsControllerCompat$Impl30$2 = new WindowInsetsControllerCompat$Impl30$2(this, windowInsetsControllerCompat$OnControllableInsetsChangedListener);
        this.mListeners.put(windowInsetsControllerCompat$OnControllableInsetsChangedListener, windowInsetsControllerCompat$Impl30$2);
        this.mInsetsController.addOnControllableInsetsChangedListener(windowInsetsControllerCompat$Impl30$2);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void controlWindowInsetsAnimation(int i, long j, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mInsetsController.controlWindowInsetsAnimation(i, j, interpolator, cancellationSignal, new WindowInsetsControllerCompat$Impl30$1(this, windowInsetsAnimationControlListenerCompat));
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public int getSystemBarsBehavior() {
        return this.mInsetsController.getSystemBarsBehavior();
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void hide(int i) {
        this.mInsetsController.hide(i);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public boolean isAppearanceLightNavigationBars() {
        return (this.mInsetsController.getSystemBarsAppearance() & 16) != 0;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public boolean isAppearanceLightStatusBars() {
        return (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void removeOnControllableInsetsChangedListener(@NonNull WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        WindowInsetsController$OnControllableInsetsChangedListener windowInsetsController$OnControllableInsetsChangedListenerRemove = this.mListeners.remove(windowInsetsControllerCompat$OnControllableInsetsChangedListener);
        if (windowInsetsController$OnControllableInsetsChangedListenerRemove != null) {
            this.mInsetsController.removeOnControllableInsetsChangedListener(windowInsetsController$OnControllableInsetsChangedListenerRemove);
        }
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setAppearanceLightNavigationBars(boolean z2) {
        if (z2) {
            this.mInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setAppearanceLightStatusBars(boolean z2) {
        if (z2) {
            this.mInsetsController.setSystemBarsAppearance(8, 8);
        } else {
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setSystemBarsBehavior(int i) {
        this.mInsetsController.setSystemBarsBehavior(i);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void show(int i) {
        this.mInsetsController.show(i);
    }

    public WindowInsetsControllerCompat$Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.mListeners = new SimpleArrayMap<>();
        this.mInsetsController = windowInsetsController;
        this.mCompatController = windowInsetsControllerCompat;
    }
}
