package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import com.discord.app.AppLog;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2(WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 widgetChatListAdapterEventsHandler$onQuickDownloadClicked$1) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler$onQuickDownloadClicked$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m.checkNotNullParameter(th, "error");
        AppLog.i("Could not download attachment due to:  \n" + th);
        Context context = (Context) this.this$0.$weakContext.get();
        if (context != null) {
            b.a.d.m.h((Context) this.this$0.$weakContext.get(), context.getString(2131888598), 0, null, 12);
        }
    }
}
