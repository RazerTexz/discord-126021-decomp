package com.discord.widgets.nux;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$handleSubmit$1$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetNuxChannelPrompt$handleSubmit$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt$handleSubmit$1$2(WidgetNuxChannelPrompt$handleSubmit$1 widgetNuxChannelPrompt$handleSubmit$1) {
        super(1);
        this.this$0 = widgetNuxChannelPrompt$handleSubmit$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        WidgetNuxChannelPrompt$handleSubmit$1 widgetNuxChannelPrompt$handleSubmit$1 = this.this$0;
        WidgetNuxChannelPrompt.access$finishActivity(widgetNuxChannelPrompt$handleSubmit$1.this$0, widgetNuxChannelPrompt$handleSubmit$1.$guildId);
    }
}
