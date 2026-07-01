package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat$Impl {

    @NonNull
    public static final WindowInsetsCompat CONSUMED = new WindowInsetsCompat$Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    public final WindowInsetsCompat mHost;

    public WindowInsetsCompat$Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.mHost = windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mHost;
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        return this.mHost;
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mHost;
    }

    public void copyRootViewBounds(@NonNull View view) {
    }

    public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat$Impl)) {
            return false;
        }
        WindowInsetsCompat$Impl windowInsetsCompat$Impl = (WindowInsetsCompat$Impl) obj;
        return isRound() == windowInsetsCompat$Impl.isRound() && isConsumed() == windowInsetsCompat$Impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), windowInsetsCompat$Impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), windowInsetsCompat$Impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), windowInsetsCompat$Impl.getDisplayCutout());
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return null;
    }

    @NonNull
    public Insets getInsets(int i) {
        return Insets.NONE;
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        if ((i & 8) == 0) {
            return Insets.NONE;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        return getSystemWindowInsets();
    }

    @NonNull
    public Insets getStableInsets() {
        return Insets.NONE;
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        return getSystemWindowInsets();
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        return Insets.NONE;
    }

    @NonNull
    public Insets getTappableElementInsets() {
        return getSystemWindowInsets();
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
    }

    @NonNull
    public WindowInsetsCompat inset(int i, int i2, int i3, int i4) {
        return CONSUMED;
    }

    public boolean isConsumed() {
        return false;
    }

    public boolean isRound() {
        return false;
    }

    public boolean isVisible(int i) {
        return true;
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
    }

    public void setRootViewData(@NonNull Insets insets) {
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
    }

    public void setStableInsets(Insets insets) {
    }
}
