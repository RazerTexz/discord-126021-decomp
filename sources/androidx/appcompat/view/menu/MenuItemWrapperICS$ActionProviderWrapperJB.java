package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider$VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public class MenuItemWrapperICS$ActionProviderWrapperJB extends MenuItemWrapperICS$ActionProviderWrapper implements ActionProvider$VisibilityListener {
    private androidx.core.view.ActionProvider$VisibilityListener mListener;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuItemWrapperICS$ActionProviderWrapperJB(MenuItemWrapperICS menuItemWrapperICS, Context context, ActionProvider actionProvider) {
        super(menuItemWrapperICS, context, actionProvider);
        this.this$0 = menuItemWrapperICS;
    }

    @Override // androidx.core.view.ActionProvider
    public boolean isVisible() {
        return this.mInner.isVisible();
    }

    @Override // android.view.ActionProvider$VisibilityListener
    public void onActionProviderVisibilityChanged(boolean z2) {
        androidx.core.view.ActionProvider$VisibilityListener actionProvider$VisibilityListener = this.mListener;
        if (actionProvider$VisibilityListener != null) {
            actionProvider$VisibilityListener.onActionProviderVisibilityChanged(z2);
        }
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView(MenuItem menuItem) {
        return this.mInner.onCreateActionView(menuItem);
    }

    @Override // androidx.core.view.ActionProvider
    public boolean overridesItemVisibility() {
        return this.mInner.overridesItemVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public void refreshVisibility() {
        this.mInner.refreshVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public void setVisibilityListener(androidx.core.view.ActionProvider$VisibilityListener actionProvider$VisibilityListener) {
        this.mListener = actionProvider$VisibilityListener;
        this.mInner.setVisibilityListener(actionProvider$VisibilityListener != null ? this : null);
    }
}
