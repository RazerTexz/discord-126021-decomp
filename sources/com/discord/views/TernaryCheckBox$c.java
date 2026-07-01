package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: TernaryCheckBox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TernaryCheckBox$c implements View$OnClickListener {
    public final /* synthetic */ TernaryCheckBox j;
    public final /* synthetic */ String k;

    public TernaryCheckBox$c(TernaryCheckBox ternaryCheckBox, String str) {
        this.j = ternaryCheckBox;
        this.k = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.h(this.j.getContext(), this.k, 0, null, 12);
    }
}
