package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import b.i.a.f.e.o.f;
import d0.l;
import d0.w.h.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.l1;
import s.a.n1;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineProgressDialog {
    public static final CoroutineProgressDialog INSTANCE = new CoroutineProgressDialog();

    private CoroutineProgressDialog() {
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v5, types: [T, androidx.appcompat.app.AlertDialog] */
    public final <Result> Object withCancellableProgressDialog(Context context, Function1<? super Continuation<? super Result>, ? extends Object> function1, Continuation<? super Result> continuation) throws Throwable {
        CoroutineProgressDialog$withCancellableProgressDialog$1 coroutineProgressDialog$withCancellableProgressDialog$1;
        Ref$ObjectRef ref$ObjectRef;
        Function1<? super Continuation<? super Result>, ? extends Object> function2;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        CoroutineContext coroutineContextPlus;
        CoroutineProgressDialog$withCancellableProgressDialog$2 coroutineProgressDialog$withCancellableProgressDialog$2;
        CoroutineContext coroutineContextPlus2;
        CoroutineProgressDialog$withCancellableProgressDialog$2 coroutineProgressDialog$withCancellableProgressDialog$3;
        if (continuation instanceof CoroutineProgressDialog$withCancellableProgressDialog$1) {
            coroutineProgressDialog$withCancellableProgressDialog$1 = (CoroutineProgressDialog$withCancellableProgressDialog$1) continuation;
            int i = coroutineProgressDialog$withCancellableProgressDialog$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineProgressDialog$withCancellableProgressDialog$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineProgressDialog$withCancellableProgressDialog$1 = new CoroutineProgressDialog$withCancellableProgressDialog$1(this, continuation);
            }
        } else {
            coroutineProgressDialog$withCancellableProgressDialog$1 = new CoroutineProgressDialog$withCancellableProgressDialog$1(this, continuation);
        }
        Object objC1 = coroutineProgressDialog$withCancellableProgressDialog$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = coroutineProgressDialog$withCancellableProgressDialog$1.label;
        try {
            if (i2 == 0) {
                l.throwOnFailure(objC1);
                CoroutineContext context2 = coroutineProgressDialog$withCancellableProgressDialog$1.getContext();
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                CoroutineDispatcher coroutineDispatcher = k0.a;
                l1 l1VarH = n.f3830b.H();
                CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 coroutineProgressDialog$withCancellableProgressDialog$dialog$1 = new CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(context, context2, null);
                coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = function1;
                coroutineProgressDialog$withCancellableProgressDialog$1.L$1 = ref$ObjectRef4;
                coroutineProgressDialog$withCancellableProgressDialog$1.L$2 = ref$ObjectRef4;
                coroutineProgressDialog$withCancellableProgressDialog$1.label = 1;
                objC1 = f.C1(l1VarH, coroutineProgressDialog$withCancellableProgressDialog$dialog$1, coroutineProgressDialog$withCancellableProgressDialog$1);
                if (objC1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef = ref$ObjectRef4;
                function2 = function1;
                ref$ObjectRef2 = ref$ObjectRef;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            Object obj = coroutineProgressDialog$withCancellableProgressDialog$1.L$0;
                            l.throwOnFailure(objC1);
                            return obj;
                        }
                        if (i2 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) coroutineProgressDialog$withCancellableProgressDialog$1.L$0;
                        l.throwOnFailure(objC1);
                        throw th;
                    }
                    ref$ObjectRef3 = (Ref$ObjectRef) coroutineProgressDialog$withCancellableProgressDialog$1.L$0;
                    try {
                        l.throwOnFailure(objC1);
                        CoroutineDispatcher coroutineDispatcher2 = k0.a;
                        coroutineContextPlus2 = n.f3830b.H().plus(n1.j);
                        coroutineProgressDialog$withCancellableProgressDialog$3 = new CoroutineProgressDialog$withCancellableProgressDialog$2(ref$ObjectRef3, null);
                        coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = objC1;
                        coroutineProgressDialog$withCancellableProgressDialog$1.label = 3;
                        if (f.C1(coroutineContextPlus2, coroutineProgressDialog$withCancellableProgressDialog$3, coroutineProgressDialog$withCancellableProgressDialog$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objC1;
                    } catch (Throwable th2) {
                        ref$ObjectRef2 = ref$ObjectRef3;
                        th = th2;
                        CoroutineDispatcher coroutineDispatcher3 = k0.a;
                        coroutineContextPlus = n.f3830b.H().plus(n1.j);
                        coroutineProgressDialog$withCancellableProgressDialog$2 = new CoroutineProgressDialog$withCancellableProgressDialog$2(ref$ObjectRef2, null);
                        coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = th;
                        coroutineProgressDialog$withCancellableProgressDialog$1.L$1 = null;
                        coroutineProgressDialog$withCancellableProgressDialog$1.L$2 = null;
                        coroutineProgressDialog$withCancellableProgressDialog$1.label = 4;
                        if (f.C1(coroutineContextPlus, coroutineProgressDialog$withCancellableProgressDialog$2, coroutineProgressDialog$withCancellableProgressDialog$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw th;
                    }
                }
                ref$ObjectRef = (Ref$ObjectRef) coroutineProgressDialog$withCancellableProgressDialog$1.L$2;
                ref$ObjectRef2 = (Ref$ObjectRef) coroutineProgressDialog$withCancellableProgressDialog$1.L$1;
                function2 = (Function1) coroutineProgressDialog$withCancellableProgressDialog$1.L$0;
                l.throwOnFailure(objC1);
            }
            coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = ref$ObjectRef2;
            coroutineProgressDialog$withCancellableProgressDialog$1.L$1 = null;
            coroutineProgressDialog$withCancellableProgressDialog$1.L$2 = null;
            coroutineProgressDialog$withCancellableProgressDialog$1.label = 2;
            objC1 = function2.invoke(coroutineProgressDialog$withCancellableProgressDialog$1);
            if (objC1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef3 = ref$ObjectRef2;
            CoroutineDispatcher coroutineDispatcher4 = k0.a;
            coroutineContextPlus2 = n.f3830b.H().plus(n1.j);
            coroutineProgressDialog$withCancellableProgressDialog$3 = new CoroutineProgressDialog$withCancellableProgressDialog$2(ref$ObjectRef3, null);
            coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = objC1;
            coroutineProgressDialog$withCancellableProgressDialog$1.label = 3;
            if (f.C1(coroutineContextPlus2, coroutineProgressDialog$withCancellableProgressDialog$3, coroutineProgressDialog$withCancellableProgressDialog$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objC1;
        } catch (Throwable th3) {
            th = th3;
            CoroutineDispatcher coroutineDispatcher5 = k0.a;
            coroutineContextPlus = n.f3830b.H().plus(n1.j);
            coroutineProgressDialog$withCancellableProgressDialog$2 = new CoroutineProgressDialog$withCancellableProgressDialog$2(ref$ObjectRef2, null);
            coroutineProgressDialog$withCancellableProgressDialog$1.L$0 = th;
            coroutineProgressDialog$withCancellableProgressDialog$1.L$1 = null;
            coroutineProgressDialog$withCancellableProgressDialog$1.L$2 = null;
            coroutineProgressDialog$withCancellableProgressDialog$1.label = 4;
            if (f.C1(coroutineContextPlus, coroutineProgressDialog$withCancellableProgressDialog$2, coroutineProgressDialog$withCancellableProgressDialog$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th;
        }
        ref$ObjectRef.element = (AlertDialog) objC1;
    }
}
