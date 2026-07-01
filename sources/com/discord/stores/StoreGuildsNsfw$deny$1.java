package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildsNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsNsfw$deny$1 extends o implements Function1<Channel, Unit> {
    public static final StoreGuildsNsfw$deny$1 INSTANCE = new StoreGuildsNsfw$deny$1();

    public StoreGuildsNsfw$deny$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        if (channel == null || channel.getNsfw()) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, 0L, null, null, 12, null);
        } else {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, null, 6, null);
        }
    }
}
