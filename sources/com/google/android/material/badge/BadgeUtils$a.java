package com.google.android.material.badge;

import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeUtils$a implements Runnable {
    public final /* synthetic */ Toolbar j;
    public final /* synthetic */ int k;
    public final /* synthetic */ BadgeDrawable l;
    public final /* synthetic */ FrameLayout m;

    public BadgeUtils$a(Toolbar toolbar, int i, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
        this.j = toolbar;
        this.k = i;
        this.l = badgeDrawable;
        this.m = frameLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(this.j, this.k);
        if (actionMenuItemView != null) {
            BadgeDrawable badgeDrawable = this.l;
            badgeDrawable.setHorizontalOffset(this.j.getResources().getDimensionPixelOffset(R$dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset) + badgeDrawable.getHorizontalOffset());
            BadgeDrawable badgeDrawable2 = this.l;
            badgeDrawable2.setVerticalOffset(this.j.getResources().getDimensionPixelOffset(R$dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset) + badgeDrawable2.getVerticalOffset());
            BadgeUtils.attachBadgeDrawable(this.l, actionMenuItemView, this.m);
        }
    }
}
