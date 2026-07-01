package com.discord.widgets.nux;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$handleSubmit$1$1 extends o implements Function1<Channel, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ WidgetNuxChannelPrompt$handleSubmit$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt$handleSubmit$1$1(WidgetNuxChannelPrompt$handleSubmit$1 widgetNuxChannelPrompt$handleSubmit$1) {
        super(1);
        this.this$0 = widgetNuxChannelPrompt$handleSubmit$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Channel channel) {
        List<PermissionOverwrite> listV;
        return new TrackNetworkActionChannelCreate((channel == null || (listV = channel.v()) == null) ? null : Boolean.valueOf(!listV.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(this.this$0.$guildId));
    }
}
