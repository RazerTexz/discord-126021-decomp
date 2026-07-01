package com.discord.utilities.coroutines;

import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.coroutines.CoroutineProgressDialog", f = "CoroutineProgressDialog.kt", l = {22, 32, 34, 34}, m = "withCancellableProgressDialog")
public final class CoroutineProgressDialog$withCancellableProgressDialog$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoroutineProgressDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog$withCancellableProgressDialog$1(CoroutineProgressDialog coroutineProgressDialog, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineProgressDialog;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.withCancellableProgressDialog(null, null, this);
    }
}
