package com.discord.widgets.status;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatStatusBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus$binding$2 extends C12236k implements Function1<View, WidgetChatStatusBinding> {
    public static final WidgetChatStatus$binding$2 INSTANCE = new WidgetChatStatus$binding$2();

    public WidgetChatStatus$binding$2() {
        super(1, WidgetChatStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatStatusBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        LinearLayout linearLayout = (LinearLayout) view;
        int i = C5419R.id.chat_status_unread_messages_mark;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_status_unread_messages_mark);
        if (imageView != null) {
            i = C5419R.id.chat_status_unread_messages_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.chat_status_unread_messages_text);
            if (textView != null) {
                return new WidgetChatStatusBinding((LinearLayout) view, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
