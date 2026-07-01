package com.discord.app;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppDialog$a implements View$OnClickListener {
    public final /* synthetic */ AppDialog j;
    public final /* synthetic */ View k;
    public final /* synthetic */ Function1 l;

    public AppDialog$a(AppDialog appDialog, View view, Function1 function1) {
        this.j = appDialog;
        this.k = view;
        this.l = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.j.dismiss();
    }
}
