package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import b.a.d.m;
import b.a.k.b;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1(WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 widgetChatListAdapterEventsHandler$onQuickDownloadClicked$1) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler$onQuickDownloadClicked$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Context context = (Context) this.this$0.$weakContext.get();
        if (context != null) {
            m.h(context, b.h(context, 2131888599, new Object[]{str}, null, 4), 0, null, 12);
        }
    }
}
