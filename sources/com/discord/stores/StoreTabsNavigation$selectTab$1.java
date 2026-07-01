package com.discord.stores;

import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreTabsNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreTabsNavigation$selectTab$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $dismissTabsDialogs;
    public final /* synthetic */ NavigationTab $navigationTab;
    public final /* synthetic */ StoreTabsNavigation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreTabsNavigation$selectTab$1(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab, boolean z2) {
        super(0);
        this.this$0 = storeTabsNavigation;
        this.$navigationTab = navigationTab;
        this.$dismissTabsDialogs = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.selectTabInternal$app_productionGoogleRelease(this.$navigationTab, this.$dismissTabsDialogs);
    }
}
