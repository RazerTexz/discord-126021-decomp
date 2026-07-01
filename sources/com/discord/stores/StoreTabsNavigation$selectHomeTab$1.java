package com.discord.stores;

import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreTabsNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreTabsNavigation$selectHomeTab$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $dismissTabsDialogs;
    public final /* synthetic */ StoreNavigation$PanelAction $panelAction;
    public final /* synthetic */ StoreTabsNavigation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreTabsNavigation$selectHomeTab$1(StoreTabsNavigation storeTabsNavigation, StoreNavigation$PanelAction storeNavigation$PanelAction, boolean z2) {
        super(0);
        this.this$0 = storeTabsNavigation;
        this.$panelAction = storeNavigation$PanelAction;
        this.$dismissTabsDialogs = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreTabsNavigation.access$handleTabSelection(this.this$0, NavigationTab.HOME);
        StoreTabsNavigation.access$notifyHomeTabSelected(this.this$0, this.$panelAction);
        if (this.$dismissTabsDialogs) {
            StoreTabsNavigation.access$dismissTabsDialogs(this.this$0);
        }
    }
}
