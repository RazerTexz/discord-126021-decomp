package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem$OnActionExpandListener;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS$OnActionExpandListenerWrapper implements MenuItem$OnActionExpandListener {
    private final MenuItem$OnActionExpandListener mObject;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = menuItem$OnActionExpandListener;
    }

    @Override // android.view.MenuItem$OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem));
    }

    @Override // android.view.MenuItem$OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem));
    }
}
