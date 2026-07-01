package androidx.appcompat.view.menu;

import androidx.core.view.ActionProvider$VisibilityListener;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemImpl$1 implements ActionProvider$VisibilityListener {
    public final /* synthetic */ MenuItemImpl this$0;

    public MenuItemImpl$1(MenuItemImpl menuItemImpl) {
        this.this$0 = menuItemImpl;
    }

    @Override // androidx.core.view.ActionProvider$VisibilityListener
    public void onActionProviderVisibilityChanged(boolean z2) {
        MenuItemImpl menuItemImpl = this.this$0;
        menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
    }
}
