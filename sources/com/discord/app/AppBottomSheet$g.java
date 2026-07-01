package com.discord.app;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$g implements View$OnClickListener {
    public final /* synthetic */ AppBottomSheet j;
    public final /* synthetic */ View k;
    public final /* synthetic */ Function1 l;

    public AppBottomSheet$g(AppBottomSheet appBottomSheet, View view, Function1 function1) {
        this.j = appBottomSheet;
        this.k = view;
        this.l = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
