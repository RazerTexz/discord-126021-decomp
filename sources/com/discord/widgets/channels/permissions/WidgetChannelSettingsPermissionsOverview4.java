package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview4 extends Lambda implements Function0<WidgetChannelSettingsPermissionsOverviewViewModel> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview4(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(0);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        long channelIdFromIntent = this.this$0.getChannelIdFromIntent();
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(channelIdFromIntent);
        return new WidgetChannelSettingsPermissionsOverviewViewModel(channelIdFromIntent, channel != null && channel.getType() == 13);
    }
}
