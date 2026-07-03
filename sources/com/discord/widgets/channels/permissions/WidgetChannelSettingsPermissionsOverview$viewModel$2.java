package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$viewModel$2 extends AbstractC12240o implements Function0<WidgetChannelSettingsPermissionsOverviewViewModel> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview$viewModel$2(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
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
