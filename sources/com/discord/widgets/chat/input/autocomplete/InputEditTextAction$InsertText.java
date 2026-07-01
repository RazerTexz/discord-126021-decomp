package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$InsertText extends InputEditTextAction {
    private final CharSequence assumedInput;
    private final IntRange insertRange;
    private final int selectionIndex;
    private final CharSequence toAppend;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputEditTextAction$InsertText(CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        m.checkNotNullParameter(charSequence2, "toAppend");
        m.checkNotNullParameter(intRange, "insertRange");
        this.assumedInput = charSequence;
        this.toAppend = charSequence2;
        this.insertRange = intRange;
        this.selectionIndex = i;
    }

    public static /* synthetic */ InputEditTextAction$InsertText copy$default(InputEditTextAction$InsertText inputEditTextAction$InsertText, CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = inputEditTextAction$InsertText.getAssumedInput();
        }
        if ((i2 & 2) != 0) {
            charSequence2 = inputEditTextAction$InsertText.toAppend;
        }
        if ((i2 & 4) != 0) {
            intRange = inputEditTextAction$InsertText.insertRange;
        }
        if ((i2 & 8) != 0) {
            i = inputEditTextAction$InsertText.selectionIndex;
        }
        return inputEditTextAction$InsertText.copy(charSequence, charSequence2, intRange, i);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getToAppend() {
        return this.toAppend;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IntRange getInsertRange() {
        return this.insertRange;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public final InputEditTextAction$InsertText copy(CharSequence assumedInput, CharSequence toAppend, IntRange insertRange, int selectionIndex) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        m.checkNotNullParameter(toAppend, "toAppend");
        m.checkNotNullParameter(insertRange, "insertRange");
        return new InputEditTextAction$InsertText(assumedInput, toAppend, insertRange, selectionIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputEditTextAction$InsertText)) {
            return false;
        }
        InputEditTextAction$InsertText inputEditTextAction$InsertText = (InputEditTextAction$InsertText) other;
        return m.areEqual(getAssumedInput(), inputEditTextAction$InsertText.getAssumedInput()) && m.areEqual(this.toAppend, inputEditTextAction$InsertText.toAppend) && m.areEqual(this.insertRange, inputEditTextAction$InsertText.insertRange) && this.selectionIndex == inputEditTextAction$InsertText.selectionIndex;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public final IntRange getInsertRange() {
        return this.insertRange;
    }

    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public final CharSequence getToAppend() {
        return this.toAppend;
    }

    public int hashCode() {
        CharSequence assumedInput = getAssumedInput();
        int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
        CharSequence charSequence = this.toAppend;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        IntRange intRange = this.insertRange;
        return ((iHashCode2 + (intRange != null ? intRange.hashCode() : 0)) * 31) + this.selectionIndex;
    }

    public String toString() {
        StringBuilder sbU = a.U("InsertText(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(", toAppend=");
        sbU.append(this.toAppend);
        sbU.append(", insertRange=");
        sbU.append(this.insertRange);
        sbU.append(", selectionIndex=");
        return a.B(sbU, this.selectionIndex, ")");
    }
}
