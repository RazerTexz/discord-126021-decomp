package androidx.appcompat.app;

import android.R$attr;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle$FrameworkActionBarDelegate implements ActionBarDrawerToggle$Delegate {
    private final Activity mActivity;
    private ActionBarDrawerToggleHoneycomb$SetIndicatorInfo mSetIndicatorInfo;

    public ActionBarDrawerToggle$FrameworkActionBarDelegate(Activity activity) {
        this.mActivity = activity;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public Context getActionBarThemedContext() {
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.mActivity;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public Drawable getThemeUpIndicator() {
        TypedArray typedArrayObtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R$attr.homeAsUpIndicator}, R$attr.actionBarStyle, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public boolean isNavigationVisible() {
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public void setActionBarDescription(int i) {
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
    public void setActionBarUpIndicator(Drawable drawable, int i) {
        android.app.ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }
}
