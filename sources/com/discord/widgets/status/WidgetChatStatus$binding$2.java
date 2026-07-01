package com.discord.widgets.status;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetChatStatusBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus$binding$2 extends k implements Function1<View, WidgetChatStatusBinding> {
    public static final WidgetChatStatus$binding$2 INSTANCE = new WidgetChatStatus$binding$2();

    public WidgetChatStatus$binding$2() {
        super(1, WidgetChatStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChatStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChatStatusBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R$id.chat_status_unread_messages_mark;
        ImageView imageView = (ImageView) view.findViewById(R$id.chat_status_unread_messages_mark);
        if (imageView != null) {
            i = R$id.chat_status_unread_messages_text;
            TextView textView = (TextView) view.findViewById(R$id.chat_status_unread_messages_text);
            if (textView != null) {
                return new WidgetChatStatusBinding((LinearLayout) view, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
