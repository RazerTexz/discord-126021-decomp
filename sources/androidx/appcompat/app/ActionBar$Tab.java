package androidx.appcompat.app;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ActionBar$Tab {
    public static final int INVALID_POSITION = -1;

    public abstract CharSequence getContentDescription();

    public abstract View getCustomView();

    public abstract Drawable getIcon();

    public abstract int getPosition();

    public abstract Object getTag();

    public abstract CharSequence getText();

    public abstract void select();

    public abstract ActionBar$Tab setContentDescription(@StringRes int i);

    public abstract ActionBar$Tab setContentDescription(CharSequence charSequence);

    public abstract ActionBar$Tab setCustomView(int i);

    public abstract ActionBar$Tab setCustomView(View view);

    public abstract ActionBar$Tab setIcon(@DrawableRes int i);

    public abstract ActionBar$Tab setIcon(Drawable drawable);

    public abstract ActionBar$Tab setTabListener(ActionBar$TabListener actionBar$TabListener);

    public abstract ActionBar$Tab setTag(Object obj);

    public abstract ActionBar$Tab setText(int i);

    public abstract ActionBar$Tab setText(CharSequence charSequence);
}
