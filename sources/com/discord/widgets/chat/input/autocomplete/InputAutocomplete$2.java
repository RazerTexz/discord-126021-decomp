package com.discord.widgets.chat.input.autocomplete;

import android.text.Editable;
import android.text.TextWatcher;
import d0.z.d.m;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$2 implements TextWatcher {
    private int before;
    private int count;
    private int start;
    public final /* synthetic */ InputAutocomplete this$0;

    public InputAutocomplete$2(InputAutocomplete inputAutocomplete) {
        this.this$0 = inputAutocomplete;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        m.checkNotNullParameter(s2, "s");
        InputAutocomplete.access$applyEditTextAction(this.this$0, InputAutocomplete.access$getViewModel$p(this.this$0).onInputTextChanged(s2, this.start, this.before, this.count));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
    }

    public final int getBefore() {
        return this.before;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getStart() {
        return this.start;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        this.start = start;
        this.before = before;
        this.count = count;
    }

    public final void setBefore(int i) {
        this.before = i;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setStart(int i) {
        this.start = i;
    }
}
