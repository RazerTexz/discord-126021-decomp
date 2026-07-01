package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationView$a implements MenuBuilder$Callback {
    public final /* synthetic */ BottomNavigationView j;

    public BottomNavigationView$a(BottomNavigationView bottomNavigationView) {
        this.j = bottomNavigationView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (BottomNavigationView.access$000(this.j) == null || menuItem.getItemId() != this.j.getSelectedItemId()) {
            return (BottomNavigationView.access$100(this.j) == null || BottomNavigationView.access$100(this.j).onNavigationItemSelected(menuItem)) ? false : true;
        }
        BottomNavigationView.access$000(this.j).onNavigationItemReselected(menuItem);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
