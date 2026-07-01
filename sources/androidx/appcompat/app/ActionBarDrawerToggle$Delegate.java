package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
public interface ActionBarDrawerToggle$Delegate {
    Context getActionBarThemedContext();

    Drawable getThemeUpIndicator();

    boolean isNavigationVisible();

    void setActionBarDescription(@StringRes int i);

    void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
}
