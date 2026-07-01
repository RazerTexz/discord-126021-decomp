package com.discord.widgets.guilds.list;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$1 extends o implements Function1<WidgetGuildsListViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$1(WidgetGuildsListViewModel widgetGuildsListViewModel) {
        super(1);
        this.this$0 = widgetGuildsListViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState) {
        invoke2(widgetGuildsListViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState) {
        WidgetGuildsListViewModel widgetGuildsListViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetGuildsListViewModel$StoreState, "storeState");
        WidgetGuildsListViewModel.access$handleStoreState(widgetGuildsListViewModel, widgetGuildsListViewModel$StoreState);
    }
}
