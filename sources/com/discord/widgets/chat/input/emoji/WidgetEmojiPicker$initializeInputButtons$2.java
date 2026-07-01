package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$initializeInputButtons$2 implements Action0 {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$initializeInputButtons$2(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    @Override // rx.functions.Action0
    public final void call() {
        OnBackspacePressedListener onBackspacePressedListenerAccess$getOnBackspacePressedListener$p = WidgetEmojiPicker.access$getOnBackspacePressedListener$p(this.this$0);
        if (onBackspacePressedListenerAccess$getOnBackspacePressedListener$p != null) {
            onBackspacePressedListenerAccess$getOnBackspacePressedListener$p.onBackspacePressed();
        }
    }
}
