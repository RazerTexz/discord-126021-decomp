package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView$a implements MenuBuilder$Callback {
    public final /* synthetic */ NavigationView j;

    public NavigationView$a(NavigationView navigationView) {
        this.j = navigationView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        NavigationView$OnNavigationItemSelectedListener navigationView$OnNavigationItemSelectedListener = this.j.listener;
        return navigationView$OnNavigationItemSelectedListener != null && navigationView$OnNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
