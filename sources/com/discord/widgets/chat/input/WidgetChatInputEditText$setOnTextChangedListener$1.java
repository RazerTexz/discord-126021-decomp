package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.TextWatcher;
import d0.g0.w;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText$setOnTextChangedListener$1 extends TextWatcher {
    private boolean empty;
    public final /* synthetic */ WidgetChatInputEditText this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputEditText$setOnTextChangedListener$1(WidgetChatInputEditText widgetChatInputEditText) {
        super(null, null, null, 7, null);
        this.this$0 = widgetChatInputEditText;
        this.empty = true;
    }

    @Override // com.discord.utilities.view.text.TextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        m.checkNotNullParameter(s2, "s");
        super.afterTextChanged(s2);
        this.this$0.saveText();
        boolean zIsEmpty = TextUtils.isEmpty(s2);
        if (this.empty != zIsEmpty) {
            this.empty = zIsEmpty;
            WidgetChatInputEditText.access$getEmptyTextSubject$p(this.this$0).onNext(Boolean.valueOf(zIsEmpty));
        }
        boolean zStartsWith$default = w.startsWith$default((CharSequence) s2.toString(), MentionUtilsKt.SLASH_CHAR, false, 2, (Object) null);
        if (WidgetChatInputEditText.access$getLastTypingEmissionMillis$p(this.this$0) - ClockFactory.get().currentTimeMillis() >= -10000 || zIsEmpty || zStartsWith$default) {
            return;
        }
        WidgetChatInputEditText.access$setLastTypingEmissionMillis$p(this.this$0, ClockFactory.get().currentTimeMillis());
        StoreStream.Companion.getUsersTyping().setUserTyping(this.this$0.getChannelId());
    }
}
