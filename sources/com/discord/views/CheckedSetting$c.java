package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$c implements View$OnClickListener {
    public final /* synthetic */ CheckedSetting j;
    public final /* synthetic */ CharSequence k;

    public CheckedSetting$c(CheckedSetting checkedSetting, CharSequence charSequence) {
        this.j = checkedSetting;
        this.k = charSequence;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.k != null) {
            m.h(this.j.getContext(), this.k, 0, null, 12);
        }
    }
}
