package com.discord.widgets.channels.settings;

import com.discord.api.channel.Channel;
import com.discord.utilities.icon.IconUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$editGroup$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ ChannelGroupDMSettingsViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ ChannelGroupDMSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel$editGroup$1(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid) {
        super(1);
        this.this$0 = channelGroupDMSettingsViewModel;
        this.$viewState = channelGroupDMSettingsViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        ChannelGroupDMSettingsViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) ChannelGroupDMSettingsViewModel$Event$SettingsSaved.INSTANCE);
        ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel = this.this$0;
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = this.$viewState;
        ChannelGroupDMSettingsViewModel.access$updateViewState(channelGroupDMSettingsViewModel, channelGroupDMSettingsViewModel$ViewState$Valid.copy(ChannelSettings.copy$default(channelGroupDMSettingsViewModel$ViewState$Valid.getChannelSettings(), channel, false, null, 6, null), IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
    }
}
