package com.discord.widgets.channels.memberlist;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$2 extends o implements Function1<WidgetChannelMembersListViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChannelMembersListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel$2(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel) {
        super(1);
        this.this$0 = widgetChannelMembersListViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel$StoreState widgetChannelMembersListViewModel$StoreState) {
        invoke2(widgetChannelMembersListViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelMembersListViewModel$StoreState widgetChannelMembersListViewModel$StoreState) {
        m.checkNotNullParameter(widgetChannelMembersListViewModel$StoreState, "storeState");
        WidgetChannelMembersListViewModel.access$handleStoreState(this.this$0, widgetChannelMembersListViewModel$StoreState);
    }
}
