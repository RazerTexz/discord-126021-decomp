package com.discord.widgets.tabs;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationView$updateView$6 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onSearchClick;

    public TabsHostBottomNavigationView$updateView$6(Function0 function0) {
        this.$onSearchClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onSearchClick.invoke();
    }
}
