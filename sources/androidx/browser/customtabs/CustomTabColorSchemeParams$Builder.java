package androidx.browser.customtabs;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public final class CustomTabColorSchemeParams$Builder {

    @Nullable
    @ColorInt
    private Integer mNavigationBarColor;

    @Nullable
    @ColorInt
    private Integer mNavigationBarDividerColor;

    @Nullable
    @ColorInt
    private Integer mSecondaryToolbarColor;

    @Nullable
    @ColorInt
    private Integer mToolbarColor;

    @NonNull
    public CustomTabColorSchemeParams build() {
        return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
    }

    @NonNull
    public CustomTabColorSchemeParams$Builder setNavigationBarColor(@ColorInt int i) {
        this.mNavigationBarColor = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
        return this;
    }

    @NonNull
    public CustomTabColorSchemeParams$Builder setNavigationBarDividerColor(@ColorInt int i) {
        this.mNavigationBarDividerColor = Integer.valueOf(i);
        return this;
    }

    @NonNull
    public CustomTabColorSchemeParams$Builder setSecondaryToolbarColor(@ColorInt int i) {
        this.mSecondaryToolbarColor = Integer.valueOf(i);
        return this;
    }

    @NonNull
    public CustomTabColorSchemeParams$Builder setToolbarColor(@ColorInt int i) {
        this.mToolbarColor = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
        return this;
    }
}
