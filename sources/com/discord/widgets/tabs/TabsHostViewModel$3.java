package com.discord.widgets.tabs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel$3 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ TabsHostViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel$3(TabsHostViewModel tabsHostViewModel) {
        super(1);
        this.this$0 = tabsHostViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        m.checkNotNullParameter(unit, "it");
        TabsHostViewModel.access$dismissSearchDialog(this.this$0);
    }
}
