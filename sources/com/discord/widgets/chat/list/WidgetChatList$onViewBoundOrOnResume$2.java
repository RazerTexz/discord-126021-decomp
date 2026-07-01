package com.discord.widgets.chat.list;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatList$onViewBoundOrOnResume$2 extends k implements Function1<Long, Unit> {
    public WidgetChatList$onViewBoundOrOnResume$2(WidgetChatList widgetChatList) {
        super(1, widgetChatList, WidgetChatList.class, "scrollTo", "scrollTo(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetChatList.access$scrollTo((WidgetChatList) this.receiver, j);
    }
}
