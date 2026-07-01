package com.discord.widgets.tabs;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationView$updateView$7 implements View$OnClickListener {
    public final /* synthetic */ Function1 $onTabSelected;

    public TabsHostBottomNavigationView$updateView$7(Function1 function1) {
        this.$onTabSelected = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onTabSelected.invoke(NavigationTab.MENTIONS);
    }
}
