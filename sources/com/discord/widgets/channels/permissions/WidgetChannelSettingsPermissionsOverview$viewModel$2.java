package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$viewModel$2 extends o implements Function0<WidgetChannelSettingsPermissionsOverviewViewModel> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview$viewModel$2(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(0);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        long jAccess$getChannelIdFromIntent = WidgetChannelSettingsPermissionsOverview.access$getChannelIdFromIntent(this.this$0);
        Channel channel = StoreStream.Companion.getChannels().getChannel(jAccess$getChannelIdFromIntent);
        return new WidgetChannelSettingsPermissionsOverviewViewModel(jAccess$getChannelIdFromIntent, channel != null && channel.getType() == 13);
    }
}
