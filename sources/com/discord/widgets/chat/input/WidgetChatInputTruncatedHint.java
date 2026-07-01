package com.discord.widgets.chat.input;

import android.text.TextUtils$TruncateAt;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcherKt;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        m.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new WidgetChatInputTruncatedHint$1(this));
    }

    public static final /* synthetic */ boolean access$getHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.hintIsTruncated;
    }

    public static final /* synthetic */ int access$getPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.previousMaxLines;
    }

    public static final /* synthetic */ void access$setHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, boolean z2) {
        widgetChatInputTruncatedHint.hintIsTruncated = z2;
    }

    public static final /* synthetic */ void access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, int i) {
        widgetChatInputTruncatedHint.previousMaxLines = i;
    }

    public static final /* synthetic */ void access$syncHint(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        widgetChatInputTruncatedHint.syncHint();
    }

    private final void syncHint() {
        boolean z2 = this.editText.length() == 0;
        this.hintIsTruncated = z2;
        if (z2) {
            this.editText.setMaxLines(1);
            this.editText.setEllipsize(TextUtils$TruncateAt.END);
            this.editText.setHint(this.hint);
        } else {
            this.editText.setMaxLines(this.previousMaxLines);
            this.editText.setEllipsize(null);
            this.editText.setHint((CharSequence) null);
        }
    }

    public final void addBindedTextWatcher(AppFragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        TextWatcherKt.addBindedTextWatcher(this.editText, fragment, new WidgetChatInputTruncatedHint$addBindedTextWatcher$1(this));
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        m.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
