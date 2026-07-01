package androidx.core.view;

import android.view.MenuItem;
import android.view.MenuItem$OnActionExpandListener;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemCompat$1 implements MenuItem$OnActionExpandListener {
    public final /* synthetic */ MenuItemCompat$OnActionExpandListener val$listener;

    public MenuItemCompat$1(MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        this.val$listener = menuItemCompat$OnActionExpandListener;
    }

    @Override // android.view.MenuItem$OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionCollapse(menuItem);
    }

    @Override // android.view.MenuItem$OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.val$listener.onMenuItemActionExpand(menuItem);
    }
}
