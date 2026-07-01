package com.discord.widgets.tabs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel$1 extends o implements Function1<TabsHostViewModel$StoreState, Unit> {
    public final /* synthetic */ TabsHostViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel$1(TabsHostViewModel tabsHostViewModel) {
        super(1);
        this.this$0 = tabsHostViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel$StoreState tabsHostViewModel$StoreState) {
        invoke2(tabsHostViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TabsHostViewModel$StoreState tabsHostViewModel$StoreState) {
        m.checkNotNullParameter(tabsHostViewModel$StoreState, "storeState");
        TabsHostViewModel.access$handleStoreState(this.this$0, tabsHostViewModel$StoreState);
    }
}
