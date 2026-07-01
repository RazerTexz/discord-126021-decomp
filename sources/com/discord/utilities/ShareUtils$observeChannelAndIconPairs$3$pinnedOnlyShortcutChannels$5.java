package com.discord.utilities;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5 extends Lambda implements Function1<Channel, ChannelShortcutInfo> {
    public static final ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5 INSTANCE = new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5();

    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ChannelShortcutInfo invoke(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelShortcutInfo(channel, 20, true);
    }
}
