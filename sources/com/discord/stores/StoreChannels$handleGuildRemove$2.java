package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$handleGuildRemove$2 extends o implements Function1<Channel, Boolean> {
    public final /* synthetic */ Guild $guild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannels$handleGuildRemove$2(Guild guild) {
        super(1);
        this.$guild = guild;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "thread");
        return channel.getGuildId() == this.$guild.getId();
    }
}
