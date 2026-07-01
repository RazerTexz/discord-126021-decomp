package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel$1 extends o implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragmentViewModel$1(WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModel) {
        super(1);
        this.this$0 = widgetChannelSettingsAddMemberFragmentViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState) {
        invoke2(widgetChannelSettingsAddMemberFragmentViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel$StoreState widgetChannelSettingsAddMemberFragmentViewModel$StoreState) {
        m.checkNotNullParameter(widgetChannelSettingsAddMemberFragmentViewModel$StoreState, "storeState");
        WidgetChannelSettingsAddMemberFragmentViewModel.access$handleStoreState(this.this$0, widgetChannelSettingsAddMemberFragmentViewModel$StoreState);
    }
}
