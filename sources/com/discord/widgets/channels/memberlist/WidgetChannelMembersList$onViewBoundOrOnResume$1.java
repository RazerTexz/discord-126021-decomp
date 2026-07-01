package com.discord.widgets.channels.memberlist;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChannelMembersListViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList$onViewBoundOrOnResume$1(WidgetChannelMembersList widgetChannelMembersList) {
        super(1);
        this.this$0 = widgetChannelMembersList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel$ViewState widgetChannelMembersListViewModel$ViewState) {
        invoke2(widgetChannelMembersListViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelMembersListViewModel$ViewState widgetChannelMembersListViewModel$ViewState) {
        m.checkNotNullParameter(widgetChannelMembersListViewModel$ViewState, "viewState");
        WidgetChannelMembersList.access$configureUI(this.this$0, widgetChannelMembersListViewModel$ViewState);
    }
}
