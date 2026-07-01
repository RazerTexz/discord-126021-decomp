package com.discord.widgets.nux;

import com.discord.models.guild.Guild;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$onViewBound$1 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt$onViewBound$1(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        super(1);
        this.this$0 = widgetNuxChannelPrompt;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        WidgetNuxChannelPrompt.access$handleGuild(this.this$0, guild);
    }
}
