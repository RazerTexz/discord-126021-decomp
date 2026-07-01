package com.discord.widgets.chat.input;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 implements OnBackspacePressedListener {
    public final /* synthetic */ TextView $chatInput;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1(TextView textView) {
        this.$chatInput = textView;
    }

    @Override // com.discord.widgets.chat.input.OnBackspacePressedListener
    public void onBackspacePressed() {
        this.$chatInput.dispatchKeyEvent(new KeyEvent(0, 67));
    }
}
