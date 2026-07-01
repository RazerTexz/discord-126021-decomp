package com.discord.app;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$g implements View$OnClickListener {
    public final /* synthetic */ AppActivity j;

    public AppActivity$g(AppActivity appActivity) {
        this.j = appActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) throws Exception {
        AppActivity appActivity = this.j;
        boolean z2 = AppActivity.m;
        appActivity.hideKeyboard(null);
        this.j.onBackPressed();
    }
}
