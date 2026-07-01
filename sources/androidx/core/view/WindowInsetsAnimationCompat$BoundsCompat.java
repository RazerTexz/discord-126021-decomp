package androidx.core.view;

import android.view.WindowInsetsAnimation$Bounds;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationCompat$BoundsCompat {
    private final Insets mLowerBound;
    private final Insets mUpperBound;

    public WindowInsetsAnimationCompat$BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
        this.mLowerBound = insets;
        this.mUpperBound = insets2;
    }

    @NonNull
    @RequiresApi(30)
    public static WindowInsetsAnimationCompat$BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation$Bounds windowInsetsAnimation$Bounds) {
        return new WindowInsetsAnimationCompat$BoundsCompat(windowInsetsAnimation$Bounds);
    }

    @NonNull
    public Insets getLowerBound() {
        return this.mLowerBound;
    }

    @NonNull
    public Insets getUpperBound() {
        return this.mUpperBound;
    }

    @NonNull
    public WindowInsetsAnimationCompat$BoundsCompat inset(@NonNull Insets insets) {
        return new WindowInsetsAnimationCompat$BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
    }

    @NonNull
    @RequiresApi(30)
    public WindowInsetsAnimation$Bounds toBounds() {
        return WindowInsetsAnimationCompat$Impl30.createPlatformBounds(this);
    }

    public String toString() {
        StringBuilder sbU = a.U("Bounds{lower=");
        sbU.append(this.mLowerBound);
        sbU.append(" upper=");
        sbU.append(this.mUpperBound);
        sbU.append("}");
        return sbU.toString();
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat$BoundsCompat(@NonNull WindowInsetsAnimation$Bounds windowInsetsAnimation$Bounds) {
        this.mLowerBound = WindowInsetsAnimationCompat$Impl30.getLowerBounds(windowInsetsAnimation$Bounds);
        this.mUpperBound = WindowInsetsAnimationCompat$Impl30.getHigherBounds(windowInsetsAnimation$Bounds);
    }
}
