package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$previewVoiceChannel$1 extends o implements Function0<Channel> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$previewVoiceChannel$1(ChannelSelector channelSelector, long j) {
        super(0);
        this.this$0 = channelSelector;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Channel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Channel invoke() {
        Channel channelFindChannelById = this.this$0.getStream().getChannels().findChannelById(this.$channelId);
        if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, this.this$0.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
            return channelFindChannelById;
        }
        return null;
    }
}
