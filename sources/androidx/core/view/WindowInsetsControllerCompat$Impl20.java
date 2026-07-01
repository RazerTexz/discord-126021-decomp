package androidx.core.view;

import android.R$id;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(20)
public class WindowInsetsControllerCompat$Impl20 extends WindowInsetsControllerCompat$Impl {

    @Nullable
    private final View mView;

    @NonNull
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl20(@NonNull Window window, @Nullable View view) {
        this.mWindow = window;
        this.mView = view;
    }

    private void hideForType(int i) {
        if (i == 1) {
            setSystemUiFlag(4);
        } else if (i == 2) {
            setSystemUiFlag(2);
        } else {
            if (i != 8) {
                return;
            }
            ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
        }
    }

    private void showForType(int i) {
        if (i == 1) {
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        }
        if (i == 2) {
            unsetSystemUiFlag(2);
            return;
        }
        if (i != 8) {
            return;
        }
        View currentFocus = this.mView;
        if (currentFocus == null || !(currentFocus.isInEditMode() || currentFocus.onCheckIsTextEditor())) {
            currentFocus = this.mWindow.getCurrentFocus();
        } else {
            currentFocus.requestFocus();
        }
        if (currentFocus == null) {
            currentFocus = this.mWindow.findViewById(R$id.content);
        }
        if (currentFocus == null || !currentFocus.hasWindowFocus()) {
            return;
        }
        currentFocus.post(new WindowInsetsControllerCompat$Impl20$1(this, currentFocus));
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void controlWindowInsetsAnimation(int i, long j, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public int getSystemBarsBehavior() {
        return 0;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void hide(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                hideForType(i2);
            }
        }
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void removeOnControllableInsetsChangedListener(@NonNull WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void setSystemBarsBehavior(int i) {
        if (i == 0) {
            unsetSystemUiFlag(6144);
            return;
        }
        if (i == 1) {
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
        } else {
            if (i != 2) {
                return;
            }
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
        }
    }

    public void setSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public void setWindowFlag(int i) {
        this.mWindow.addFlags(i);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public void show(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                showForType(i2);
            }
        }
    }

    public void unsetSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    public void unsetWindowFlag(int i) {
        this.mWindow.clearFlags(i);
    }
}
