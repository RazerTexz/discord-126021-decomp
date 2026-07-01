package com.discord.widgets.user;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel$1 extends o implements Function1<WidgetUserSetCustomStatusViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetUserSetCustomStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel$1(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        super(1);
        this.this$0 = widgetUserSetCustomStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel$StoreState widgetUserSetCustomStatusViewModel$StoreState) {
        invoke2(widgetUserSetCustomStatusViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSetCustomStatusViewModel$StoreState widgetUserSetCustomStatusViewModel$StoreState) {
        m.checkNotNullParameter(widgetUserSetCustomStatusViewModel$StoreState, "storeState");
        WidgetUserSetCustomStatusViewModel.access$handleStoreState(this.this$0, widgetUserSetCustomStatusViewModel$StoreState);
    }
}
