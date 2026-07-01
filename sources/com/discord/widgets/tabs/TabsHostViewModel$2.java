package com.discord.widgets.tabs;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ TabsHostViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel$2(TabsHostViewModel tabsHostViewModel) {
        super(1);
        this.this$0 = tabsHostViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        TabsHostViewModel.access$handleBottomNavHeight(this.this$0, i);
    }
}
