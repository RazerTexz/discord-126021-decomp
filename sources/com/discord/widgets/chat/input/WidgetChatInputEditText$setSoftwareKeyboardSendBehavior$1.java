package com.discord.widgets.chat.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView$OnEditorActionListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText$setSoftwareKeyboardSendBehavior$1 implements TextView$OnEditorActionListener {
    public final /* synthetic */ WidgetChatInputEditText this$0;

    public WidgetChatInputEditText$setSoftwareKeyboardSendBehavior$1(WidgetChatInputEditText widgetChatInputEditText) {
        this.this$0 = widgetChatInputEditText;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i2 = i & 255;
        if (this.this$0.getOnSendListener() == null || i2 != 6) {
            return false;
        }
        Function0<Unit> onSendListener = this.this$0.getOnSendListener();
        if (onSendListener == null) {
            return true;
        }
        onSendListener.invoke();
        return true;
    }
}
