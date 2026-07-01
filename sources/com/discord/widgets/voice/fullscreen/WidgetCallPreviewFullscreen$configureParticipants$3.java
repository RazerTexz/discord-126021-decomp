package com.discord.widgets.voice.fullscreen;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureParticipants$3 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$configureParticipants$3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, Channel channel) {
        super(1);
        this.this$0 = widgetCallPreviewFullscreen;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, this.this$0, this.$channel, "Fullscreen Voice Channel Preview", null, null, 24, null);
    }
}
