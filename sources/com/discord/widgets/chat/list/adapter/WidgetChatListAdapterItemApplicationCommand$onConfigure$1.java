package com.discord.widgets.chat.list.adapter;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand$onConfigure$1 extends o implements Function1<TextView, Unit> {
    public static final WidgetChatListAdapterItemApplicationCommand$onConfigure$1 INSTANCE = new WidgetChatListAdapterItemApplicationCommand$onConfigure$1();

    public WidgetChatListAdapterItemApplicationCommand$onConfigure$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "$this$copyTextOnLongPress");
        textView.setOnLongClickListener(new WidgetChatListAdapterItemApplicationCommand$onConfigure$1$1(textView));
    }
}
