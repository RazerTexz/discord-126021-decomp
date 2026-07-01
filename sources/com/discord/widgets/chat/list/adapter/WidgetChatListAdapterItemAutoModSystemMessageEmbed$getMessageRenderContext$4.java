package com.discord.widgets.chat.list.adapter;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        super(1);
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetChatListAdapter$Data data = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0).getData();
        WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
    }
}
