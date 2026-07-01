package com.discord.widgets.guildscheduledevent;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$1 implements TextWatcher {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        String string;
        if (s2 == null || (string = s2.toString()) == null) {
            return;
        }
        WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).setTopic(string);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
