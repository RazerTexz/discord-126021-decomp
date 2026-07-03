package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$Model$Companion$getSortedGuildChannels$$inlined$also$lambda$1 */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9197xdd5448eb extends AbstractC12240o implements Function1<Channel, Boolean> {
    public final /* synthetic */ int $channelType$inlined;
    public final /* synthetic */ Map $guildChannels$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9197xdd5448eb(Map map, int i) {
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
        C12238m.checkNotNullParameter(channel, "channel");
        int i = this.$channelType$inlined;
        if (i == 0) {
            return ChannelUtils.m7698v(channel);
        }
        if (i == 2) {
            return ChannelUtils.m7699w(channel);
        }
        int type = channel.getType();
        int i2 = this.$channelType$inlined;
        return type == i2 || i2 == -1;
    }
}
