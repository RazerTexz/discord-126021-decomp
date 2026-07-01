package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.RxCoroutineUtilsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.a.n;
import s.a.k0;
import s.a.l1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxCoroutineExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2", f = "RxCoroutineExtensions.kt", l = {35, 40}, m = "invokeSuspend")
public final class RxCoroutineExtensionsKt$appAwaitSingle$2<T> extends k implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Boolean $suppressToast;
    public final /* synthetic */ Observable $this_appAwaitSingle;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineExtensionsKt$appAwaitSingle$2(Observable observable, Context context, Boolean bool, Continuation continuation) {
        super(2, continuation);
        this.$this_appAwaitSingle = observable;
        this.$context = context;
        this.$suppressToast = bool;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        RxCoroutineExtensionsKt$appAwaitSingle$2 rxCoroutineExtensionsKt$appAwaitSingle$2 = new RxCoroutineExtensionsKt$appAwaitSingle$2(this.$this_appAwaitSingle, this.$context, this.$suppressToast, continuation);
        rxCoroutineExtensionsKt$appAwaitSingle$2.L$0 = obj;
        return rxCoroutineExtensionsKt$appAwaitSingle$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((RxCoroutineExtensionsKt$appAwaitSingle$2) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x009b  */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        T t;
        Throwable th;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Error errorCreate;
        l1 l1Var;
        RxCoroutineExtensionsKt$appAwaitSingle$2$1 rxCoroutineExtensionsKt$appAwaitSingle$2$1;
        Error error;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = (T) new WeakReference(this.$context);
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            AppErrorTag appErrorTag = (AppErrorTag) coroutineScope.getCoroutineContext().get(AppErrorTag$Key.INSTANCE);
            if (appErrorTag == null || (t = (T) appErrorTag.getErrorTag()) == null) {
                t = (T) coroutineScope.getClass().getSimpleName();
            }
            ref$ObjectRef4.element = t;
            try {
                Observable observable = this.$this_appAwaitSingle;
                this.L$0 = ref$ObjectRef3;
                this.L$1 = ref$ObjectRef4;
                this.label = 1;
                obj = RxCoroutineUtilsKt.awaitSingle(observable, this);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            } catch (Throwable th2) {
                th = th2;
                ref$ObjectRef = ref$ObjectRef3;
                ref$ObjectRef2 = ref$ObjectRef4;
                errorCreate = Error.create(th);
                CoroutineDispatcher coroutineDispatcher = k0.a;
                l1Var = n.f3830b;
                rxCoroutineExtensionsKt$appAwaitSingle$2$1 = new RxCoroutineExtensionsKt$appAwaitSingle$2$1(this, th, ref$ObjectRef2, ref$ObjectRef, null);
                this.L$0 = errorCreate;
                this.L$1 = null;
                this.label = 2;
                if (f.C1(l1Var, rxCoroutineExtensionsKt$appAwaitSingle$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                error = errorCreate;
                m.checkNotNullExpressionValue(error, "error");
                throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
            }
        }
        if (i == 1) {
            Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
            Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
            try {
                l.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                ref$ObjectRef2 = ref$ObjectRef5;
                ref$ObjectRef = ref$ObjectRef6;
                errorCreate = Error.create(th);
                CoroutineDispatcher coroutineDispatcher2 = k0.a;
                l1Var = n.f3830b;
                rxCoroutineExtensionsKt$appAwaitSingle$2$1 = new RxCoroutineExtensionsKt$appAwaitSingle$2$1(this, th, ref$ObjectRef2, ref$ObjectRef, null);
                this.L$0 = errorCreate;
                this.L$1 = null;
                this.label = 2;
                if (f.C1(l1Var, rxCoroutineExtensionsKt$appAwaitSingle$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                error = errorCreate;
                m.checkNotNullExpressionValue(error, "error");
                throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
            }
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        error = (Error) this.L$0;
        l.throwOnFailure(obj);
        m.checkNotNullExpressionValue(error, "error");
        throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
    }
}
