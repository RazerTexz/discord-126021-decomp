package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnLongClickListener;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$1$1 implements View$OnLongClickListener {
    public final /* synthetic */ TextView $this_copyTextOnLongPress;

    public WidgetChatListAdapterItemEmbed$1$1(TextView textView) {
        this.$this_copyTextOnLongPress = textView;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        Context context = this.$this_copyTextOnLongPress.getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence text = this.$this_copyTextOnLongPress.getText();
        m.checkNotNullExpressionValue(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        b.a.d.m.c(context, text, 0, 4);
        return false;
    }
}
