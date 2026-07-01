package com.discord.stores;

import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreTabsNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreTabsNavigation$observeSelectedTab$1 extends o implements Function0<NavigationTab> {
    public final /* synthetic */ StoreTabsNavigation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreTabsNavigation$observeSelectedTab$1(StoreTabsNavigation storeTabsNavigation) {
        super(0);
        this.this$0 = storeTabsNavigation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ NavigationTab invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final NavigationTab invoke() {
        return this.this$0.getSelectedTab();
    }
}
