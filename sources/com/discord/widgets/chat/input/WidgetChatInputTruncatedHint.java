package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcherKt;
import com.lytefast.flexinput.widget.FlexEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$1 */
    /* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
    public static final class C77551 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C77551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            if (WidgetChatInputTruncatedHint.this.hintIsTruncated) {
                return;
            }
            WidgetChatInputTruncatedHint.this.previousMaxLines = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$addBindedTextWatcher$1 */
    /* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
    public static final class C77561 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C77561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetChatInputTruncatedHint.this.syncHint();
        }
    }

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        C12238m.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new C77551());
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
        C12238m.checkNotNullParameter(fragment, "fragment");
        TextWatcherKt.addBindedTextWatcher(this.editText, fragment, new C77561());
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        C12238m.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
