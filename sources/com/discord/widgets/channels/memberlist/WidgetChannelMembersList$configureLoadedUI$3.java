package com.discord.widgets.channels.memberlist;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$configureLoadedUI$3 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChannelMembersListViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList$configureLoadedUI$3(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded) {
        super(0);
        this.this$0 = widgetChannelMembersList;
        this.$viewState = widgetChannelMembersListViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChannelMembersList.access$getViewModel$p(this.this$0).onThreadJoinLeaveClicked(this.$viewState.getChannel().getId(), this.$viewState.isThreadJoined());
    }
}
