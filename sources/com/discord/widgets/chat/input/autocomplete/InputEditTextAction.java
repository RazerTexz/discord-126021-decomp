package com.discord.widgets.chat.input.autocomplete;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InputEditTextAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputEditTextAction {
    private final CharSequence assumedInput;

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
