package com.discord.widgets.chat.input.autocomplete;

import android.text.style.CharacterStyle;
import b.d.b.a.a;
import d0.t.h0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class InputEditTextAction$ReplacePillSpans extends InputEditTextAction {
    private final CharSequence assumedInput;
    private final Map<IntRange, List<CharacterStyle>> spans;

    public /* synthetic */ InputEditTextAction$ReplacePillSpans(CharSequence charSequence, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i & 2) != 0 ? h0.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputEditTextAction$ReplacePillSpans copy$default(InputEditTextAction$ReplacePillSpans inputEditTextAction$ReplacePillSpans, CharSequence charSequence, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = inputEditTextAction$ReplacePillSpans.getAssumedInput();
        }
        if ((i & 2) != 0) {
            map = inputEditTextAction$ReplacePillSpans.spans;
        }
        return inputEditTextAction$ReplacePillSpans.copy(charSequence, map);
    }

    public final CharSequence component1() {
        return getAssumedInput();
    }

    public final Map<IntRange, List<CharacterStyle>> component2() {
        return this.spans;
    }

    public final InputEditTextAction$ReplacePillSpans copy(CharSequence assumedInput, Map<IntRange, ? extends List<? extends CharacterStyle>> spans) {
        m.checkNotNullParameter(assumedInput, "assumedInput");
        m.checkNotNullParameter(spans, "spans");
        return new InputEditTextAction$ReplacePillSpans(assumedInput, spans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputEditTextAction$ReplacePillSpans)) {
            return false;
        }
        InputEditTextAction$ReplacePillSpans inputEditTextAction$ReplacePillSpans = (InputEditTextAction$ReplacePillSpans) other;
        return m.areEqual(getAssumedInput(), inputEditTextAction$ReplacePillSpans.getAssumedInput()) && m.areEqual(this.spans, inputEditTextAction$ReplacePillSpans.spans);
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
        StringBuilder sbU = a.U("ReplacePillSpans(assumedInput=");
        sbU.append(getAssumedInput());
        sbU.append(", spans=");
        return a.M(sbU, this.spans, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InputEditTextAction$ReplacePillSpans(CharSequence charSequence, Map<IntRange, ? extends List<? extends CharacterStyle>> map) {
        super(charSequence, null);
        m.checkNotNullParameter(charSequence, "assumedInput");
        m.checkNotNullParameter(map, "spans");
        this.assumedInput = charSequence;
        this.spans = map;
    }
}
