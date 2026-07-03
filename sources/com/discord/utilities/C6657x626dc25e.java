package com.discord.utilities;

import com.discord.api.channel.Channel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5 */
/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6657x626dc25e extends AbstractC12240o implements Function1<Channel, ChannelShortcutInfo> {
    public static final C6657x626dc25e INSTANCE = new C6657x626dc25e();

    public C6657x626dc25e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ChannelShortcutInfo invoke(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        return new ChannelShortcutInfo(channel, 20, true);
    }
}
