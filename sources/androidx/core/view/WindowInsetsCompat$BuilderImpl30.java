package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public class WindowInsetsCompat$BuilderImpl30 extends WindowInsetsCompat$BuilderImpl29 {
    public WindowInsetsCompat$BuilderImpl30() {
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setInsets(int i, @NonNull Insets insets) {
        this.mPlatBuilder.setInsets(WindowInsetsCompat$TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
        this.mPlatBuilder.setInsetsIgnoringVisibility(WindowInsetsCompat$TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    public void setVisible(int i, boolean z2) {
        this.mPlatBuilder.setVisible(WindowInsetsCompat$TypeImpl30.toPlatformType(i), z2);
    }

    public WindowInsetsCompat$BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
    }
}
