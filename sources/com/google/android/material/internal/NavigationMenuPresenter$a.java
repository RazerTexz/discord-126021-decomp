package com.google.android.material.internal;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationMenuPresenter$a implements View$OnClickListener {
    public final /* synthetic */ NavigationMenuPresenter j;

    public NavigationMenuPresenter$a(NavigationMenuPresenter navigationMenuPresenter) {
        this.j = navigationMenuPresenter;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        boolean z2 = true;
        this.j.setUpdateSuspended(true);
        MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
        NavigationMenuPresenter navigationMenuPresenter = this.j;
        boolean zPerformItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
        if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
            this.j.adapter.b(itemData);
        } else {
            z2 = false;
        }
        this.j.setUpdateSuspended(false);
        if (z2) {
            this.j.updateMenuView(false);
        }
    }
}
