package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS$OnMenuItemClickListenerWrapper implements MenuItem$OnMenuItemClickListener {
    private final MenuItem$OnMenuItemClickListener mObject;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem$OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = menuItem$OnMenuItemClickListener;
    }

    @Override // android.view.MenuItem$OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(menuItem));
    }
}
