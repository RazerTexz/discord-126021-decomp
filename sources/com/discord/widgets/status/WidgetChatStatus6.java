package com.discord.widgets.status;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChatStatusBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetChatStatus$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus6 extends FunctionReferenceImpl implements Function1<View, WidgetChatStatusBinding> {
    public static final WidgetChatStatus6 INSTANCE = new WidgetChatStatus6();

    public WidgetChatStatus6() {
        super(1, WidgetChatStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatStatusBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.chat_status_unread_messages_mark;
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_status_unread_messages_mark);
        if (imageView != null) {
            i = R.id.chat_status_unread_messages_text;
            TextView textView = (TextView) view.findViewById(R.id.chat_status_unread_messages_text);
            if (textView != null) {
                return new WidgetChatStatusBinding((LinearLayout) view, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
