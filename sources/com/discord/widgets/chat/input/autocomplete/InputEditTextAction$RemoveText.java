package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$RemoveText extends InputEditTextAction {
    private final CharSequence assumedInput;
    private final IntRange range;
    private final int selectionIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputEditTextAction$RemoveText(CharSequence charSequence, IntRange intRange, int i) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        m.checkNotNullParameter(intRange, "range");
        this.assumedInput = charSequence;
        this.range = intRange;
        this.selectionIndex = i;
    }

    public static /* synthetic */ InputEditTextAction$RemoveText copy$default(InputEditTextAction$RemoveText inputEditTextAction$RemoveText, CharSequence charSequence, IntRange intRange, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = inputEditTextAction$RemoveText.getAssumedInput();
        }
        if ((i2 & 2) != 0) {
            intRange = inputEditTextAction$RemoveText.range;
        }
        if ((i2 & 4) != 0) {
            i = inputEditTextAction$RemoveText.selectionIndex;
        }
        return inputEditTextAction$RemoveText.copy(charSequence, intRange, i);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public final InputEditTextAction$RemoveText copy(CharSequence assumedInput, IntRange range, int selectionIndex) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        m.checkNotNullParameter(range, "range");
        return new InputEditTextAction$RemoveText(assumedInput, range, selectionIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputEditTextAction$RemoveText)) {
            return false;
        }
        InputEditTextAction$RemoveText inputEditTextAction$RemoveText = (InputEditTextAction$RemoveText) other;
        return m.areEqual(getAssumedInput(), inputEditTextAction$RemoveText.getAssumedInput()) && m.areEqual(this.range, inputEditTextAction$RemoveText.range) && this.selectionIndex == inputEditTextAction$RemoveText.selectionIndex;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final int getSelectionIndex() {
        return this.selectionIndex;
    }

    public int hashCode() {
        CharSequence assumedInput = getAssumedInput();
        int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
        IntRange intRange = this.range;
        return ((iHashCode + (intRange != null ? intRange.hashCode() : 0)) * 31) + this.selectionIndex;
    }

    public String toString() {
        StringBuilder sbU = a.U("RemoveText(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(", range=");
        sbU.append(this.range);
        sbU.append(", selectionIndex=");
        return a.B(sbU, this.selectionIndex, ")");
    }
}
