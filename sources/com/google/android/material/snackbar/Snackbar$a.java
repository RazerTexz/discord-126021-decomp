package com.google.android.material.snackbar;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class Snackbar$a implements View$OnClickListener {
    public final /* synthetic */ View$OnClickListener j;
    public final /* synthetic */ Snackbar k;

    public Snackbar$a(Snackbar snackbar, View$OnClickListener view$OnClickListener) {
        this.k = snackbar;
        this.j = view$OnClickListener;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.j.onClick(view);
        this.k.dispatchDismiss(1);
    }
}
