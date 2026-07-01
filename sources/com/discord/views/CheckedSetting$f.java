package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;
import rx.functions.Action0;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$f implements View$OnClickListener {
    public final /* synthetic */ Action0 j;

    public CheckedSetting$f(Action0 action0) {
        this.j = action0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.call();
    }
}
