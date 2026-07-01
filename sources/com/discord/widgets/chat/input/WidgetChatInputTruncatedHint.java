package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcher4;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (WidgetChatInputTruncatedHint.this.hintIsTruncated) {
                return;
            }
            WidgetChatInputTruncatedHint.this.previousMaxLines = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$addBindedTextWatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetChatInputTruncatedHint.this.syncHint();
        }
    }

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new AnonymousClass1());
    }

    private final void syncHint() {
        boolean z2 = this.editText.length() == 0;
        this.hintIsTruncated = z2;
        if (z2) {
            this.editText.setMaxLines(1);
            this.editText.setEllipsize(TextUtils.TruncateAt.END);
            this.editText.setHint(this.hint);
        } else {
            this.editText.setMaxLines(this.previousMaxLines);
            this.editText.setEllipsize(null);
            this.editText.setHint((CharSequence) null);
        }
    }

    public final void addBindedTextWatcher(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        TextWatcher4.addBindedTextWatcher(this.editText, fragment, new AnonymousClass1());
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        Intrinsics3.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
