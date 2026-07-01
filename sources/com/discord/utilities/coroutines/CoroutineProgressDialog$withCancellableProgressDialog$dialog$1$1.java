package com.discord.utilities.coroutines;

import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import b.i.a.f.e.o.f;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1 implements DialogInterface$OnCancelListener {
    public final /* synthetic */ CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 this$0;

    public CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1(CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 coroutineProgressDialog$withCancellableProgressDialog$dialog$1) {
        this.this$0 = coroutineProgressDialog$withCancellableProgressDialog$dialog$1;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        f.s(this.this$0.$myCoroutineContext, null, 1, null);
    }
}
