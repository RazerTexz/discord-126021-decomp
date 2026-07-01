package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$ClearSpans extends InputEditTextAction {
    private final CharSequence assumedInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputEditTextAction$ClearSpans(CharSequence charSequence) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        this.assumedInput = charSequence;
    }

    public static /* synthetic */ InputEditTextAction$ClearSpans copy$default(InputEditTextAction$ClearSpans inputEditTextAction$ClearSpans, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = inputEditTextAction$ClearSpans.getAssumedInput();
        }
        return inputEditTextAction$ClearSpans.copy(charSequence);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    public final InputEditTextAction$ClearSpans copy(CharSequence assumedInput) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        return new InputEditTextAction$ClearSpans(assumedInput);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof InputEditTextAction$ClearSpans) && m.areEqual(getAssumedInput(), ((InputEditTextAction$ClearSpans) other).getAssumedInput());
        }
        return true;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public int hashCode() {
        CharSequence assumedInput = getAssumedInput();
        if (assumedInput != null) {
            return assumedInput.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ClearSpans(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(")");
        return sbU.toString();
    }
}
