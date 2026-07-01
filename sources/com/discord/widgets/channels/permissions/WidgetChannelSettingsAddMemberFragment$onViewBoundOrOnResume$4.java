package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4 extends o implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(1);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel$ViewState widgetChannelSettingsAddMemberFragmentViewModel$ViewState) {
        invoke2(widgetChannelSettingsAddMemberFragmentViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel$ViewState widgetChannelSettingsAddMemberFragmentViewModel$ViewState) {
        m.checkNotNullParameter(widgetChannelSettingsAddMemberFragmentViewModel$ViewState, "viewState");
        WidgetChannelSettingsAddMemberFragment.access$configureUI(this.this$0, widgetChannelSettingsAddMemberFragmentViewModel$ViewState);
        WidgetChannelSettingsAddMemberFragment.access$getSelectedSubject$p(this.this$0).onNext(widgetChannelSettingsAddMemberFragmentViewModel$ViewState.getSelected());
    }
}
