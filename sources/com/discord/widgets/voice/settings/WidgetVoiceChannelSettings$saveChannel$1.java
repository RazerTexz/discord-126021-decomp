package com.discord.widgets.voice.settings;

import b.a.d.m;
import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$saveChannel$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceChannelSettings$saveChannel$1(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        super(1);
        this.this$0 = widgetVoiceChannelSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.g(this.this$0.getContext(), 2131887605, 0, null, 12);
    }
}
