package com.discord.chips_view;

import android.text.Editable;
import android.text.TextWatcher;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView$b implements TextWatcher {
    public final /* synthetic */ ChipsView j;

    public ChipsView$b(ChipsView chipsView) {
        this.j = chipsView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        m.checkNotNullParameter(editable, "s");
        Function1<CharSequence, Unit> textChangedListener = this.j.getTextChangedListener();
        if (textChangedListener != null) {
            textChangedListener.invoke(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m.checkNotNullParameter(charSequence, "s");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m.checkNotNullParameter(charSequence, "s");
    }
}
