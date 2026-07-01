package com.discord.utilities.coroutines;

import androidx.appcompat.app.AlertDialog;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$2", f = "CoroutineProgressDialog.kt", l = {}, m = "invokeSuspend")
public final class CoroutineProgressDialog$withCancellableProgressDialog$2 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef $dialog;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog$withCancellableProgressDialog$2(Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.$dialog = ref$ObjectRef;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog$withCancellableProgressDialog$2(this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineProgressDialog$withCancellableProgressDialog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        ((AlertDialog) this.$dialog.element).dismiss();
        return Unit.a;
    }
}
