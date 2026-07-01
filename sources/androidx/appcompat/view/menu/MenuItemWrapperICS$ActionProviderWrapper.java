package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS$ActionProviderWrapper extends ActionProvider {
    public final android.view.ActionProvider mInner;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
        super(context);
        this.this$0 = menuItemWrapperICS;
        this.mInner = actionProvider;
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return this.mInner.hasSubMenu();
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        return this.mInner.onCreateActionView();
    }

    @Override // androidx.core.view.ActionProvider
    public boolean onPerformDefaultAction() {
        return this.mInner.onPerformDefaultAction();
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(subMenu));
    }
}
