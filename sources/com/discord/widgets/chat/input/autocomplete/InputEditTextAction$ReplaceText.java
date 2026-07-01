package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$ReplaceText extends InputEditTextAction {
    private final CharSequence assumedInput;
    private final CharSequence newText;
    private final int selectionIndex;

    public /* synthetic */ InputEditTextAction$ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, charSequence2, (i2 & 4) != 0 ? charSequence2.length() : i);
    }

    public static /* synthetic */ InputEditTextAction$ReplaceText copy$default(InputEditTextAction$ReplaceText inputEditTextAction$ReplaceText, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = inputEditTextAction$ReplaceText.getAssumedInput();
        }
        if ((i2 & 2) != 0) {
            charSequence2 = inputEditTextAction$ReplaceText.newText;
        }
        if ((i2 & 4) != 0) {
            i = inputEditTextAction$ReplaceText.selectionIndex;
        }
        return inputEditTextAction$ReplaceText.copy(charSequence, charSequence2, i);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getNewText() {
        return this.newText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public final InputEditTextAction$ReplaceText copy(CharSequence assumedInput, CharSequence newText, int selectionIndex) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        m.checkNotNullParameter(newText, "newText");
        return new InputEditTextAction$ReplaceText(assumedInput, newText, selectionIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputEditTextAction$ReplaceText)) {
            return false;
        }
        InputEditTextAction$ReplaceText inputEditTextAction$ReplaceText = (InputEditTextAction$ReplaceText) other;
        return m.areEqual(getAssumedInput(), inputEditTextAction$ReplaceText.getAssumedInput()) && m.areEqual(this.newText, inputEditTextAction$ReplaceText.newText) && this.selectionIndex == inputEditTextAction$ReplaceText.selectionIndex;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public final CharSequence getNewText() {
        return this.newText;
    }

    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public int hashCode() {
        CharSequence assumedInput = getAssumedInput();
        int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
        CharSequence charSequence = this.newText;
        return ((iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.selectionIndex;
    }

    public String toString() {
        StringBuilder sbU = a.U("ReplaceText(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(", newText=");
        sbU.append(this.newText);
        sbU.append(", selectionIndex=");
        return a.B(sbU, this.selectionIndex, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputEditTextAction$ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        m.checkNotNullParameter(charSequence2, "newText");
        this.assumedInput = charSequence;
        this.newText = charSequence2;
        this.selectionIndex = i;
    }
}
