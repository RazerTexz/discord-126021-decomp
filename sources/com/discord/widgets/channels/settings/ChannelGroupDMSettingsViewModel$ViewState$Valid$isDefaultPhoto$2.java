package com.discord.widgets.channels.settings;

import com.discord.utilities.icon.IconUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$ViewState$Valid$isDefaultPhoto$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ ChannelGroupDMSettingsViewModel$ViewState$Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel$ViewState$Valid$isDefaultPhoto$2(ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = channelGroupDMSettingsViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getEditedIconUrl() == null || m.areEqual(this.this$0.getEditedIconUrl(), IconUtils.INSTANCE.getDefaultForGroupDM(this.this$0.getChannelSettings().getChannel().getId()));
    }
}
