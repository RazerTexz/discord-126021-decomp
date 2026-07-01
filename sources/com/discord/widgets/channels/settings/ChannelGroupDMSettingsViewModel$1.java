package com.discord.widgets.channels.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$1 extends o implements Function1<ChannelGroupDMSettingsViewModel$StoreState, Unit> {
    public final /* synthetic */ ChannelGroupDMSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel$1(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel) {
        super(1);
        this.this$0 = channelGroupDMSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel$StoreState channelGroupDMSettingsViewModel$StoreState) {
        invoke2(channelGroupDMSettingsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelGroupDMSettingsViewModel$StoreState channelGroupDMSettingsViewModel$StoreState) {
        m.checkNotNullParameter(channelGroupDMSettingsViewModel$StoreState, "storeState");
        ChannelGroupDMSettingsViewModel.access$handleStoreState(this.this$0, channelGroupDMSettingsViewModel$StoreState);
    }
}
