package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: TargetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TargetChannelSelector {
    public final Channel getTargetChannel(Map<Long, Channel> invitableChannels, Long channelId) {
        Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
        ArrayList arrayList = new ArrayList(invitableChannels.values());
        Collections.sort(arrayList, ChannelUtils.h(Channel.INSTANCE));
        if (invitableChannels.containsKey(channelId)) {
            return invitableChannels.get(channelId);
        }
        if (!arrayList.isEmpty()) {
            return (Channel) arrayList.get(0);
        }
        return null;
    }
}
