package com.discord.widgets.chat.input;

import android.widget.TextView;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText$Companion {
    private WidgetChatInputEditText$Companion() {
    }

    public final String toStringSafe(TextView textView) {
        m.checkNotNullParameter(textView, "textView");
        try {
            return textView.getText().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public /* synthetic */ WidgetChatInputEditText$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
