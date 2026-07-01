package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $channelNameLength;
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed, int i) {
        super(1);
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed;
        this.$channelNameLength = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("channelHook", new WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1(this));
    }
}
