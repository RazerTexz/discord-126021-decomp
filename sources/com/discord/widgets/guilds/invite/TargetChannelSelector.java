package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: TargetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TargetChannelSelector {
    public final Channel getTargetChannel(Map<Long, Channel> invitableChannels, Long channelId) {
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        ArrayList arrayList = new ArrayList(invitableChannels.values());
        Collections.sort(arrayList, ChannelUtils.h(Channel.Companion));
        if (invitableChannels.containsKey(channelId)) {
            return invitableChannels.get(channelId);
        }
        if (!arrayList.isEmpty()) {
            return (Channel) arrayList.get(0);
        }
        return null;
    }
}
