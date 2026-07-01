package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$Model$Companion$getSortedGuildChannels$$inlined$also$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels3 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ int $channelType$inlined;
    public final /* synthetic */ Map $guildChannels$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels3(Map map, int i) {
        super(1);
        this.$guildChannels$inlined = map;
        this.$channelType$inlined = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        int i = this.$channelType$inlined;
        if (i == 0) {
            return ChannelUtils.v(channel);
        }
        if (i == 2) {
            return ChannelUtils.w(channel);
        }
        int type = channel.getType();
        int i2 = this.$channelType$inlined;
        return type == i2 || i2 == -1;
    }
}
