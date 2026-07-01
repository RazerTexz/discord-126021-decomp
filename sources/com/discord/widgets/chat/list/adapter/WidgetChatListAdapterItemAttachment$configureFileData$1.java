package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureFileData$1 extends o implements Function1<View, Unit> {
    public static final WidgetChatListAdapterItemAttachment$configureFileData$1 INSTANCE = new WidgetChatListAdapterItemAttachment$configureFileData$1();

    public WidgetChatListAdapterItemAttachment$configureFileData$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        TextView textView = (TextView) view;
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        CharSequence text = textView.getText();
        m.checkNotNullExpressionValue(text, "it.text");
        b.a.d.m.c(context, text, 0, 4);
    }
}
