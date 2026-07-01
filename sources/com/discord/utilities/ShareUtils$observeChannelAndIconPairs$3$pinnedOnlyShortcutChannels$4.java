package com.discord.utilities;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4 extends o implements Function1<Long, Channel> {
    public final /* synthetic */ Map $channelsById;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(Map map) {
        super(1);
        this.$channelsById = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return (Channel) this.$channelsById.get(Long.valueOf(j));
    }
}
