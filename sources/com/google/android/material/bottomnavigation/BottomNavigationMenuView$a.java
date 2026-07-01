package com.google.android.material.bottomnavigation;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationMenuView$a implements View$OnClickListener {
    public final /* synthetic */ BottomNavigationMenuView j;

    public BottomNavigationMenuView$a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.j = bottomNavigationMenuView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
        if (BottomNavigationMenuView.access$100(this.j).performItemAction(itemData, BottomNavigationMenuView.access$000(this.j), 0)) {
            return;
        }
        itemData.setChecked(true);
    }
}
