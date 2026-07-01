package com.discord.widgets.home;

import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureNavigationDrawerAction$1 extends o implements Function1<StoreNavigation$PanelAction, Unit> {
    public final /* synthetic */ StoreNavigation $this_configureNavigationDrawerAction;
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$configureNavigationDrawerAction$1(WidgetHome widgetHome, StoreNavigation storeNavigation) {
        super(1);
        this.this$0 = widgetHome;
        this.$this_configureNavigationDrawerAction = storeNavigation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation$PanelAction storeNavigation$PanelAction) {
        invoke2(storeNavigation$PanelAction);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation$PanelAction storeNavigation$PanelAction) {
        m.checkNotNullParameter(storeNavigation$PanelAction, "it");
        this.$this_configureNavigationDrawerAction.setNavigationPanelAction(storeNavigation$PanelAction, WidgetHome.access$getBinding$p(this.this$0).c);
    }
}
