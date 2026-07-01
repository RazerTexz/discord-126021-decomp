package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$SelectText extends InputEditTextAction {
    private final CharSequence assumedInput;
    private final IntRange selection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputEditTextAction$SelectText(CharSequence charSequence, IntRange intRange) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        m.checkNotNullParameter(intRange, "selection");
        this.assumedInput = charSequence;
        this.selection = intRange;
    }

    public static /* synthetic */ InputEditTextAction$SelectText copy$default(InputEditTextAction$SelectText inputEditTextAction$SelectText, CharSequence charSequence, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = inputEditTextAction$SelectText.getAssumedInput();
        }
        if ((i & 2) != 0) {
            intRange = inputEditTextAction$SelectText.selection;
        }
        return inputEditTextAction$SelectText.copy(charSequence, intRange);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getSelection() {
        return this.selection;
    }

    public final InputEditTextAction$SelectText copy(CharSequence assumedInput, IntRange selection) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        m.checkNotNullParameter(selection, "selection");
        return new InputEditTextAction$SelectText(assumedInput, selection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputEditTextAction$SelectText)) {
            return false;
        }
        InputEditTextAction$SelectText inputEditTextAction$SelectText = (InputEditTextAction$SelectText) other;
        return m.areEqual(getAssumedInput(), inputEditTextAction$SelectText.getAssumedInput()) && m.areEqual(this.selection, inputEditTextAction$SelectText.selection);
    }

    @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public final IntRange getSelection() {
        return this.selection;
    }

    public int hashCode() {
        CharSequence assumedInput = getAssumedInput();
        int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
        IntRange intRange = this.selection;
        return iHashCode + (intRange != null ? intRange.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectText(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(", selection=");
        sbU.append(this.selection);
        sbU.append(")");
        return sbU.toString();
    }
}
