package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle$ToolbarCompatDelegate implements ActionBarDrawerToggle$Delegate {
    public final CharSequence mDefaultContentDescription;
    public final Drawable mDefaultUpIndicator;
    public final Toolbar mToolbar;

    public ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar toolbar) {
        this.mToolbar = toolbar;
        this.mDefaultUpIndicator = toolbar.getNavigationIcon();
        this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public Context getActionBarThemedContext() {
        return this.mToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public Drawable getThemeUpIndicator() {
        return this.mDefaultUpIndicator;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public boolean isNavigationVisible() {
        return true;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public void setActionBarDescription(@StringRes int i) {
        if (i == 0) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
        this.mToolbar.setNavigationIcon(drawable);
        setActionBarDescription(i);
    }
}
