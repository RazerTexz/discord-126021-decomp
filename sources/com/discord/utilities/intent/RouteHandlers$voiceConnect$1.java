package com.discord.utilities.intent;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$voiceConnect$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ boolean $isServicePermissionDeniedRedirect;
    public final /* synthetic */ WeakReference $weakContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$voiceConnect$1(WeakReference weakReference, long j, boolean z2) {
        super(1);
        this.$weakContext = weakReference;
        this.$channelId = j;
        this.$isServicePermissionDeniedRedirect = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Context context = (Context) this.$weakContext.get();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "weakContext.get() ?: return@appSubscribe");
            m.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.B(channel)) {
                return;
            }
            StoreStream.Companion.getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, context, this.$channelId, this.$isServicePermissionDeniedRedirect, null, null, 24, null);
        }
    }
}
