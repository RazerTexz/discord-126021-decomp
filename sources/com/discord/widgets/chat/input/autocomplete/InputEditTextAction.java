package com.discord.widgets.chat.input.autocomplete;

import android.text.style.CharacterStyle;
import b.d.b.a.outline;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

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
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
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
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            return new ClearSpans(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ClearSpans) && Intrinsics3.areEqual(getAssumedInput(), ((ClearSpans) other).getAssumedInput());
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
            StringBuilder sbU = outline.U("ClearSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class InsertText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 insertRange;
        private final int selectionIndex;
        private final CharSequence toAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsertText(CharSequence charSequence, CharSequence charSequence2, Ranges2 ranges2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(charSequence2, "toAppend");
            Intrinsics3.checkNotNullParameter(ranges2, "insertRange");
            this.assumedInput = charSequence;
            this.toAppend = charSequence2;
            this.insertRange = ranges2;
            this.selectionIndex = i;
        }

        public static /* synthetic */ InsertText copy$default(InsertText insertText, CharSequence charSequence, CharSequence charSequence2, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = insertText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                charSequence2 = insertText.toAppend;
            }
            if ((i2 & 4) != 0) {
                ranges2 = insertText.insertRange;
            }
            if ((i2 & 8) != 0) {
                i = insertText.selectionIndex;
            }
            return insertText.copy(charSequence, charSequence2, ranges2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getToAppend() {
            return this.toAppend;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Ranges2 getInsertRange() {
            return this.insertRange;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final InsertText copy(CharSequence assumedInput, CharSequence toAppend, Ranges2 insertRange, int selectionIndex) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(toAppend, "toAppend");
            Intrinsics3.checkNotNullParameter(insertRange, "insertRange");
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
            return Intrinsics3.areEqual(getAssumedInput(), insertText.getAssumedInput()) && Intrinsics3.areEqual(this.toAppend, insertText.toAppend) && Intrinsics3.areEqual(this.insertRange, insertText.insertRange) && this.selectionIndex == insertText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getInsertRange() {
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
            Ranges2 ranges2 = this.insertRange;
            return ((iHashCode2 + (ranges2 != null ? ranges2.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InsertText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", toAppend=");
            sbU.append(this.toAppend);
            sbU.append(", insertRange=");
            sbU.append(this.insertRange);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class None extends InputEditTextAction {
        private final CharSequence assumedInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public None(CharSequence charSequence) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
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
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            return new None(assumedInput);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof None) && Intrinsics3.areEqual(getAssumedInput(), ((None) other).getAssumedInput());
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
            StringBuilder sbU = outline.U("None(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class RemoveText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 range;
        private final int selectionIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveText(CharSequence charSequence, Ranges2 ranges2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(ranges2, "range");
            this.assumedInput = charSequence;
            this.range = ranges2;
            this.selectionIndex = i;
        }

        public static /* synthetic */ RemoveText copy$default(RemoveText removeText, CharSequence charSequence, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charSequence = removeText.getAssumedInput();
            }
            if ((i2 & 2) != 0) {
                ranges2 = removeText.range;
            }
            if ((i2 & 4) != 0) {
                i = removeText.selectionIndex;
            }
            return removeText.copy(charSequence, ranges2, i);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Ranges2 getRange() {
            return this.range;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public final RemoveText copy(CharSequence assumedInput, Ranges2 range, int selectionIndex) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(range, "range");
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
            return Intrinsics3.areEqual(getAssumedInput(), removeText.getAssumedInput()) && Intrinsics3.areEqual(this.range, removeText.range) && this.selectionIndex == removeText.selectionIndex;
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getRange() {
            return this.range;
        }

        public final int getSelectionIndex() {
            return this.selectionIndex;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Ranges2 ranges2 = this.range;
            return ((iHashCode + (ranges2 != null ? ranges2.hashCode() : 0)) * 31) + this.selectionIndex;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RemoveText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", range=");
            sbU.append(this.range);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplaceCharacterStyleSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<Ranges2, List<CharacterStyle>> spans;

        public /* synthetic */ ReplaceCharacterStyleSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? Maps6.emptyMap() : map);
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

        public final Map<Ranges2, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplaceCharacterStyleSpans copy(CharSequence assumedInput, Map<Ranges2, ? extends List<? extends CharacterStyle>> spans) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(spans, "spans");
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
            return Intrinsics3.areEqual(getAssumedInput(), replaceCharacterStyleSpans.getAssumedInput()) && Intrinsics3.areEqual(this.spans, replaceCharacterStyleSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<Ranges2, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<Ranges2, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplaceCharacterStyleSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return outline.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplaceCharacterStyleSpans(CharSequence charSequence, Map<Ranges2, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(map, "spans");
            this.assumedInput = charSequence;
            this.spans = map;
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class ReplacePillSpans extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Map<Ranges2, List<CharacterStyle>> spans;

        public /* synthetic */ ReplacePillSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i & 2) != 0 ? Maps6.emptyMap() : map);
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

        public final Map<Ranges2, List<CharacterStyle>> component2() {
            return this.spans;
        }

        public final ReplacePillSpans copy(CharSequence assumedInput, Map<Ranges2, ? extends List<? extends CharacterStyle>> spans) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(spans, "spans");
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
            return Intrinsics3.areEqual(getAssumedInput(), replacePillSpans.getAssumedInput()) && Intrinsics3.areEqual(this.spans, replacePillSpans.spans);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Map<Ranges2, List<CharacterStyle>> getSpans() {
            return this.spans;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Map<Ranges2, List<CharacterStyle>> map = this.spans;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplacePillSpans(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", spans=");
            return outline.M(sbU, this.spans, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ReplacePillSpans(CharSequence charSequence, Map<Ranges2, ? extends List<? extends CharacterStyle>> map) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(map, "spans");
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
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(newText, "newText");
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
            return Intrinsics3.areEqual(getAssumedInput(), replaceText.getAssumedInput()) && Intrinsics3.areEqual(this.newText, replaceText.newText) && this.selectionIndex == replaceText.selectionIndex;
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
            StringBuilder sbU = outline.U("ReplaceText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", newText=");
            sbU.append(this.newText);
            sbU.append(", selectionIndex=");
            return outline.B(sbU, this.selectionIndex, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceText(CharSequence charSequence, CharSequence charSequence2, int i) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(charSequence2, "newText");
            this.assumedInput = charSequence;
            this.newText = charSequence2;
            this.selectionIndex = i;
        }
    }

    /* JADX INFO: compiled from: InputEditTextAction.kt */
    public static final /* data */ class SelectText extends InputEditTextAction {
        private final CharSequence assumedInput;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectText(CharSequence charSequence, Ranges2 ranges2) {
            super(charSequence, null);
            Intrinsics3.checkNotNullParameter(charSequence, "assumedInput");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.assumedInput = charSequence;
            this.selection = ranges2;
        }

        public static /* synthetic */ SelectText copy$default(SelectText selectText, CharSequence charSequence, Ranges2 ranges2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = selectText.getAssumedInput();
            }
            if ((i & 2) != 0) {
                ranges2 = selectText.selection;
            }
            return selectText.copy(charSequence, ranges2);
        }

        public final CharSequence component1() {
            return getAssumedInput();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Ranges2 getSelection() {
            return this.selection;
        }

        public final SelectText copy(CharSequence assumedInput, Ranges2 selection) {
            Intrinsics3.checkNotNullParameter(assumedInput, "assumedInput");
            Intrinsics3.checkNotNullParameter(selection, "selection");
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
            return Intrinsics3.areEqual(getAssumedInput(), selectText.getAssumedInput()) && Intrinsics3.areEqual(this.selection, selectText.selection);
        }

        @Override // com.discord.widgets.chat.input.autocomplete.InputEditTextAction
        public CharSequence getAssumedInput() {
            return this.assumedInput;
        }

        public final Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            CharSequence assumedInput = getAssumedInput();
            int iHashCode = (assumedInput != null ? assumedInput.hashCode() : 0) * 31;
            Ranges2 ranges2 = this.selection;
            return iHashCode + (ranges2 != null ? ranges2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SelectText(assumedInput=");
            sbU.append(getAssumedInput());
            sbU.append(", selection=");
            sbU.append(this.selection);
            sbU.append(")");
            return sbU.toString();
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
