package com.discord.widgets.chat.input.autocomplete;

import android.text.style.CharacterStyle;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputEditTextAction {
    private final CharSequence assumedInput;

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ClearSpans extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearSpans(CharSequence charSequence) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ ClearSpans copy$default(ClearSpans clearSpans, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = clearSpans.getAssumedInput();
            }
            return clearSpans.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final ClearSpans copy(CharSequence assumedInput) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            return new ClearSpans(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ClearSpans) && C12238m.areEqual(getAssumedInput(), ((ClearSpans) other).getAssumedInput());
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
            StringBuilder sbM833U = C1643a.m833U("ClearSpans(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class InsertText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange insertRange;
        private final int selectionIndex;
        private final CharSequence toAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertText(CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(charSequence2, "toAppend");
            C12238m.checkNotNullParameter(intRange, "insertRange");
            this.assumedInput = charSequence;
            this.toAppend = charSequence2;
            this.insertRange = intRange;
            this.selectionIndex = i;
        }

        public static /* synthetic */ InsertText copy$default(InsertText insertText, CharSequence charSequence, CharSequence charSequence2, IntRange intRange, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = insertText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = insertText.toAppend;
            }
            if ((i2 & 4) != 0) {
                intRange = insertText.insertRange;
            }
            if ((i2 & 8) != 0) {
                i = insertText.selectionIndex;
            }
            return insertText.copy(charSequence, charSequence2, intRange, i);
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

        public final InsertText copy(CharSequence assumedInput, CharSequence toAppend, IntRange insertRange, int selectionIndex) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(toAppend, "toAppend");
            C12238m.checkNotNullParameter(insertRange, "insertRange");
            return new InsertText(assumedInput, toAppend, insertRange, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertText)) {
                return false;
            }
            InsertText insertText = (InsertText) other;
            return C12238m.areEqual(getAssumedInput(), insertText.getAssumedInput()) && C12238m.areEqual(this.toAppend, insertText.toAppend) && C12238m.areEqual(this.insertRange, insertText.insertRange) && this.selectionIndex == insertText.selectionIndex;
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
            StringBuilder sbM833U = C1643a.m833U("InsertText(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", toAppend=");
            sbM833U.append(this.toAppend);
            sbM833U.append(", insertRange=");
            sbM833U.append(this.insertRange);
            sbM833U.append(", selectionIndex=");
            return C1643a.m814B(sbM833U, this.selectionIndex, ")");
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class None extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public None(CharSequence charSequence) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            this.assumedInput = charSequence;
        }

        public static /* synthetic */ None copy$default(None none, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = none.getAssumedInput();
            }
            return none.copy(charSequence);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final None copy(CharSequence assumedInput) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            return new None(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof None) && C12238m.areEqual(getAssumedInput(), ((None) other).getAssumedInput());
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
            StringBuilder sbM833U = C1643a.m833U("None(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class RemoveText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange range;
        private final int selectionIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveText(CharSequence charSequence, IntRange intRange, int i) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(intRange, "range");
            this.assumedInput = charSequence;
            this.range = intRange;
            this.selectionIndex = i;
        }

        public static /* synthetic */ RemoveText copy$default(RemoveText removeText, CharSequence charSequence, IntRange intRange, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = removeText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                intRange = removeText.range;
            }
            if ((i2 & 4) != 0) {
                i = removeText.selectionIndex;
            }
            return removeText.copy(charSequence, intRange, i);
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

        public final RemoveText copy(CharSequence assumedInput, IntRange range, int selectionIndex) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(range, "range");
            return new RemoveText(assumedInput, range, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveText)) {
                return false;
            }
            RemoveText removeText = (RemoveText) other;
            return C12238m.areEqual(getAssumedInput(), removeText.getAssumedInput()) && C12238m.areEqual(this.range, removeText.range) && this.selectionIndex == removeText.selectionIndex;
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
            StringBuilder sbM833U = C1643a.m833U("RemoveText(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", range=");
            sbM833U.append(this.range);
            sbM833U.append(", selectionIndex=");
            return C1643a.m814B(sbM833U, this.selectionIndex, ")");
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplaceCharacterStyleSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<IntRange, List<CharacterStyle>> spans;

        public /* synthetic */ ReplaceCharacterStyleSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? C12136h0.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplaceCharacterStyleSpans copy$default(ReplaceCharacterStyleSpans replaceCharacterStyleSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replaceCharacterStyleSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replaceCharacterStyleSpans.spans;
            }
            return replaceCharacterStyleSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<IntRange, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplaceCharacterStyleSpans copy(CharSequence assumedInput, Map<IntRange, ? extends List<? extends CharacterStyle>> spans) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(spans, "spans");
            return new ReplaceCharacterStyleSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceCharacterStyleSpans)) {
                return false;
            }
            ReplaceCharacterStyleSpans replaceCharacterStyleSpans = (ReplaceCharacterStyleSpans) other;
            return C12238m.areEqual(getAssumedInput(), replaceCharacterStyleSpans.getAssumedInput()) && C12238m.areEqual(this.spans, replaceCharacterStyleSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<IntRange, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<IntRange, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ReplaceCharacterStyleSpans(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", spans=");
            return C1643a.m825M(sbM833U, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplaceCharacterStyleSpans(CharSequence charSequence, Map<IntRange, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplacePillSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<IntRange, List<CharacterStyle>> spans;

        public /* synthetic */ ReplacePillSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? C12136h0.emptyMap() : map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReplacePillSpans copy$default(ReplacePillSpans replacePillSpans, CharSequence charSequence, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = replacePillSpans.getAssumedInput();
            }
            if ((i & 2) != 0) {
                map = replacePillSpans.spans;
            }
            return replacePillSpans.copy(charSequence, map);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        public final Map<IntRange, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplacePillSpans copy(CharSequence assumedInput, Map<IntRange, ? extends List<? extends CharacterStyle>> spans) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(spans, "spans");
            return new ReplacePillSpans(assumedInput, spans);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplacePillSpans)) {
                return false;
            }
            ReplacePillSpans replacePillSpans = (ReplacePillSpans) other;
            return C12238m.areEqual(getAssumedInput(), replacePillSpans.getAssumedInput()) && C12238m.areEqual(this.spans, replacePillSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<IntRange, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<IntRange, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ReplacePillSpans(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", spans=");
            return C1643a.m825M(sbM833U, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplacePillSpans(CharSequence charSequence, Map<IntRange, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplaceText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final CharSequence newText;
        private final int selectionIndex;

        public /* synthetic */ ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, charSequence2, (i2 & 4) != 0 ? charSequence2.length() : i);
        }

        public static /* synthetic */ ReplaceText copy$default(ReplaceText replaceText, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = replaceText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = replaceText.newText;
            }
            if ((i2 & 4) != 0) {
                i = replaceText.selectionIndex;
            }
            return replaceText.copy(charSequence, charSequence2, i);
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

        public final ReplaceText copy(CharSequence assumedInput, CharSequence newText, int selectionIndex) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(newText, "newText");
            return new ReplaceText(assumedInput, newText, selectionIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplaceText)) {
                return false;
            }
            ReplaceText replaceText = (ReplaceText) other;
            return C12238m.areEqual(getAssumedInput(), replaceText.getAssumedInput()) && C12238m.areEqual(this.newText, replaceText.newText) && this.selectionIndex == replaceText.selectionIndex;
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
            StringBuilder sbM833U = C1643a.m833U("ReplaceText(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", newText=");
            sbM833U.append(this.newText);
            sbM833U.append(", selectionIndex=");
            return C1643a.m814B(sbM833U, this.selectionIndex, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(charSequence2, "newText");
            this.assumedInput = charSequence;
            this.newText = charSequence2;
            this.selectionIndex = i;
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class SelectText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final IntRange selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectText(CharSequence charSequence, IntRange intRange) {
            super(charSequence, null);
            C12238m.checkNotNullParameter(charSequence, "assumedInput");
            C12238m.checkNotNullParameter(intRange, "selection");
            this.assumedInput = charSequence;
            this.selection = intRange;
        }

        public static /* synthetic */ SelectText copy$default(SelectText selectText, CharSequence charSequence, IntRange intRange, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = selectText.getAssumedInput();
            }
            if ((i & 2) != 0) {
                intRange = selectText.selection;
            }
            return selectText.copy(charSequence, intRange);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final IntRange getSelection() {
            return this.selection;
        }

        public final SelectText copy(CharSequence assumedInput, IntRange selection) {
            C12238m.checkNotNullParameter(assumedInput, "assumedInput");
            C12238m.checkNotNullParameter(selection, "selection");
            return new SelectText(assumedInput, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectText)) {
                return false;
            }
            SelectText selectText = (SelectText) other;
            return C12238m.areEqual(getAssumedInput(), selectText.getAssumedInput()) && C12238m.areEqual(this.selection, selectText.selection);
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
            StringBuilder sbM833U = C1643a.m833U("SelectText(assumedInput=");
            sbM833U.append(getAssumedInput());
            sbM833U.append(", selection=");
            sbM833U.append(this.selection);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    private InputEditTextAction(CharSequence charSequence) {
        this.assumedInput = charSequence;
    }

    public CharSequence getAssumedInput() {
        return this.assumedInput;
    }

    public /* synthetic */ InputEditTextAction(CharSequence charSequence, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence);
    }
}
