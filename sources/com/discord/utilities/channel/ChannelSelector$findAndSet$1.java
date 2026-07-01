package com.discord.utilities.channel;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$findAndSet$1 extends o implements Function0<Channel> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$findAndSet$1(ChannelSelector channelSelector, long j, Context context) {
        super(0);
        this.this$0 = channelSelector;
        this.$channelId = j;
        this.$context = context;
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
        Context context = this.$context;
        if (context != null) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            String string = context.getString(2131892026);
            m.checkNotNullExpressionValue(string, "context.getString(R.stri…sible_channel_link_title)");
            accessibilityUtils.sendAnnouncement(context, string);
        }
        return null;
    }
}
