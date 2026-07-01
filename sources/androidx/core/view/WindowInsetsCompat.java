package androidx.core.view;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final WindowInsetsCompat$Impl mImpl;

    static {
        if (Build$VERSION.SDK_INT >= 30) {
            CONSUMED = WindowInsetsCompat$Impl30.CONSUMED;
        } else {
            CONSUMED = WindowInsetsCompat$Impl.CONSUMED;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            this.mImpl = new WindowInsetsCompat$Impl30(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.mImpl = new WindowInsetsCompat$Impl29(this, windowInsets);
        } else if (i >= 28) {
            this.mImpl = new WindowInsetsCompat$Impl28(this, windowInsets);
        } else {
            this.mImpl = new WindowInsetsCompat$Impl21(this, windowInsets);
        }
    }

    public static Insets insetInsets(@NonNull Insets insets, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, insets.left - i);
        int iMax2 = Math.max(0, insets.top - i2);
        int iMax3 = Math.max(0, insets.right - i3);
        int iMax4 = Math.max(0, insets.bottom - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? insets : Insets.of(iMax, iMax2, iMax3, iMax4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int i) {
        return this.mImpl.getInsets(i);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return this.mImpl.getInsetsIgnoringVisibility(i);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(WindowInsetsCompat$Type.all());
        Insets insets2 = Insets.NONE;
        return (insets.equals(insets2) && getInsetsIgnoringVisibility(WindowInsetsCompat$Type.all() ^ WindowInsetsCompat$Type.ime()).equals(insets2) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = this.mImpl;
        if (windowInsetsCompat$Impl == null) {
            return 0;
        }
        return windowInsetsCompat$Impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int i) {
        return this.mImpl.isVisible(i);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new WindowInsetsCompat$Builder(this).setSystemWindowInsets(Insets.of(i, i2, i3, i4)).build();
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    public void setRootViewData(@NonNull Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    public void setStableInsets(@Nullable Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = this.mImpl;
        if (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl20) {
            return ((WindowInsetsCompat$Impl20) windowInsetsCompat$Impl).mPlatformInsets;
        }
        return null;
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return this.mImpl.inset(i, i2, i3, i4);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new WindowInsetsCompat$Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            WindowInsetsCompat$Impl windowInsetsCompat$Impl = windowInsetsCompat.mImpl;
            int i = Build$VERSION.SDK_INT;
            if (i >= 30 && (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl30)) {
                this.mImpl = new WindowInsetsCompat$Impl30(this, (WindowInsetsCompat$Impl30) windowInsetsCompat$Impl);
            } else if (i >= 29 && (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl29)) {
                this.mImpl = new WindowInsetsCompat$Impl29(this, (WindowInsetsCompat$Impl29) windowInsetsCompat$Impl);
            } else if (i >= 28 && (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl28)) {
                this.mImpl = new WindowInsetsCompat$Impl28(this, (WindowInsetsCompat$Impl28) windowInsetsCompat$Impl);
            } else if (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl21) {
                this.mImpl = new WindowInsetsCompat$Impl21(this, (WindowInsetsCompat$Impl21) windowInsetsCompat$Impl);
            } else if (windowInsetsCompat$Impl instanceof WindowInsetsCompat$Impl20) {
                this.mImpl = new WindowInsetsCompat$Impl20(this, (WindowInsetsCompat$Impl20) windowInsetsCompat$Impl);
            } else {
                this.mImpl = new WindowInsetsCompat$Impl(this);
            }
            windowInsetsCompat$Impl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new WindowInsetsCompat$Impl(this);
    }
}
