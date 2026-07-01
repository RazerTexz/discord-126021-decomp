package com.discord.widgets.channels.memberlist;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$onViewBoundOrOnResume$2 extends o implements Function1<WidgetChannelMembersListViewModel$Event, Unit> {
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList$onViewBoundOrOnResume$2(WidgetChannelMembersList widgetChannelMembersList) {
        super(1);
        this.this$0 = widgetChannelMembersList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel$Event widgetChannelMembersListViewModel$Event) {
        invoke2(widgetChannelMembersListViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelMembersListViewModel$Event widgetChannelMembersListViewModel$Event) {
        m.checkNotNullParameter(widgetChannelMembersListViewModel$Event, "event");
        if (m.areEqual(widgetChannelMembersListViewModel$Event, WidgetChannelMembersListViewModel$Event$ScrollToTop.INSTANCE)) {
            WidgetChannelMembersList.access$scrollToTop(this.this$0);
        } else if (m.areEqual(widgetChannelMembersListViewModel$Event, WidgetChannelMembersListViewModel$Event$UpdateRanges.INSTANCE)) {
            WidgetChannelMembersList.access$updateRanges(this.this$0);
        } else if (widgetChannelMembersListViewModel$Event instanceof WidgetChannelMembersListViewModel$Event$Error) {
            WidgetChannelMembersList.access$showError(this.this$0, (WidgetChannelMembersListViewModel$Event$Error) widgetChannelMembersListViewModel$Event);
        }
    }
}
