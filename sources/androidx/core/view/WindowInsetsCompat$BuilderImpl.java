package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat$BuilderImpl {
    private final WindowInsetsCompat mInsets;
    public Insets[] mInsetsTypeMask;

    public WindowInsetsCompat$BuilderImpl() {
        this(new WindowInsetsCompat((WindowInsetsCompat) null));
    }

    public final void applyInsetTypes() {
        Insets[] insetsArr = this.mInsetsTypeMask;
        if (insetsArr != null) {
            Insets insets = insetsArr[WindowInsetsCompat$Type.indexOf(1)];
            Insets insets2 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(2)];
            if (insets2 == null) {
                insets2 = this.mInsets.getInsets(2);
            }
            if (insets == null) {
                insets = this.mInsets.getInsets(1);
            }
            setSystemWindowInsets(Insets.max(insets, insets2));
            Insets insets3 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(16)];
            if (insets3 != null) {
                setSystemGestureInsets(insets3);
            }
            Insets insets4 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(32)];
            if (insets4 != null) {
                setMandatorySystemGestureInsets(insets4);
            }
            Insets insets5 = this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(64)];
            if (insets5 != null) {
                setTappableElementInsets(insets5);
            }
        }
    }

    @NonNull
    public WindowInsetsCompat build() {
        applyInsetTypes();
        return this.mInsets;
    }

    public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
    }

    public void setInsets(int i, @NonNull Insets insets) {
        if (this.mInsetsTypeMask == null) {
            this.mInsetsTypeMask = new Insets[9];
        }
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.mInsetsTypeMask[WindowInsetsCompat$Type.indexOf(i2)] = insets;
            }
        }
    }

    public void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
        if (i == 8) {
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }
    }

    public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
    }

    public void setStableInsets(@NonNull Insets insets) {
    }

    public void setSystemGestureInsets(@NonNull Insets insets) {
    }

    public void setSystemWindowInsets(@NonNull Insets insets) {
    }

    public void setTappableElementInsets(@NonNull Insets insets) {
    }

    public void setVisible(int i, boolean z2) {
    }

    public WindowInsetsCompat$BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.mInsets = windowInsetsCompat;
    }
}
