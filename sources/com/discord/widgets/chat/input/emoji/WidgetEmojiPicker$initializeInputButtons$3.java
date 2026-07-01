package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.input.OnBackspacePressedListener;
import d0.k;
import d0.k$a;
import d0.l;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$initializeInputButtons$3 implements Action0 {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$initializeInputButtons$3(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    @Override // rx.functions.Action0
    public final void call() {
        WidgetEmojiPicker widgetEmojiPicker = this.this$0;
        try {
            k$a k_a = k.j;
            k.m97constructorimpl(Boolean.valueOf(WidgetEmojiPicker.access$getBinding$p(widgetEmojiPicker).f.performHapticFeedback(3)));
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            k.m97constructorimpl(l.createFailure(th));
        }
        OnBackspacePressedListener onBackspacePressedListenerAccess$getOnBackspacePressedListener$p = WidgetEmojiPicker.access$getOnBackspacePressedListener$p(this.this$0);
        if (onBackspacePressedListenerAccess$getOnBackspacePressedListener$p != null) {
            onBackspacePressedListenerAccess$getOnBackspacePressedListener$p.onBackspacePressed();
        }
    }
}
