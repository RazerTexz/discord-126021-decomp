package com.discord.widgets.chat.list.adapter;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$1 extends o implements Function1<TextView, Unit> {
    public static final WidgetChatListAdapterItemEmbed$1 INSTANCE = new WidgetChatListAdapterItemEmbed$1();

    public WidgetChatListAdapterItemEmbed$1() {
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
        textView.setOnLongClickListener(new WidgetChatListAdapterItemEmbed$1$1(textView));
    }
}
