package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.RxCoroutineUtilsKt;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p659s.p660a.AbstractC13128l1;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: RxCoroutineExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2 */
    /* JADX INFO: compiled from: RxCoroutineExtensions.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2", m10085f = "RxCoroutineExtensions.kt", m10086l = {35, 40}, m10087m = "invokeSuspend")
    public static final class C67402<T> extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Boolean $suppressToast;
        public final /* synthetic */ Observable $this_appAwaitSingle;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public int label;

        /* JADX INFO: renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RxCoroutineExtensions.kt */
        @InterfaceC12188e(m10084c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1", m10085f = "RxCoroutineExtensions.kt", m10086l = {}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: $e */
            public final /* synthetic */ Throwable f18979$e;
            public final /* synthetic */ Ref$ObjectRef $errorTag;
            public final /* synthetic */ Ref$ObjectRef $weakContext;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Throwable th, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
                super(2, continuation);
                this.f18979$e = th;
                this.$errorTag = ref$ObjectRef;
                this.$weakContext = ref$ObjectRef2;
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass1(this.f18979$e, this.$errorTag, this.$weakContext, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) throws Throwable {
                C12183c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
                Error.handle(this.f18979$e, (String) this.$errorTag.element, null, (Context) ((WeakReference) this.$weakContext.element).get(), C67402.this.$suppressToast);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67402(Observable observable, Context context, Boolean bool, Continuation continuation) {
            super(2, continuation);
            this.$this_appAwaitSingle = observable;
            this.$context = context;
            this.$suppressToast = bool;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C67402 c67402 = new C67402(this.$this_appAwaitSingle, this.$context, this.$suppressToast, continuation);
            c67402.L$0 = obj;
            return c67402;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((C67402) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x009b  */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            T t;
            Throwable th;
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            Error errorCreate;
            AbstractC13128l1 abstractC13128l1;
            AnonymousClass1 anonymousClass1;
            Error error;
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = (T) new WeakReference(this.$context);
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                AppErrorTag appErrorTag = (AppErrorTag) coroutineScope.getCoroutineContext().get(AppErrorTag.Key.INSTANCE);
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
                    CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
                    abstractC13128l1 = C13031n.f27700b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate;
                    this.L$1 = null;
                    this.label = 2;
                    if (C3404f.m4197C1(abstractC13128l1, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    error = errorCreate;
                    C12238m.checkNotNullExpressionValue(error, "error");
                    throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
                }
            }
            if (i == 1) {
                Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
                try {
                    C12113l.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    ref$ObjectRef2 = ref$ObjectRef5;
                    ref$ObjectRef = ref$ObjectRef6;
                    errorCreate = Error.create(th);
                    CoroutineDispatcher coroutineDispatcher2 = C13124k0.f27866a;
                    abstractC13128l1 = C13031n.f27700b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate;
                    this.L$1 = null;
                    this.label = 2;
                    if (C3404f.m4197C1(abstractC13128l1, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    error = errorCreate;
                    C12238m.checkNotNullExpressionValue(error, "error");
                    throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
                }
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            error = (Error) this.L$0;
            C12113l.throwOnFailure(obj);
            C12238m.checkNotNullExpressionValue(error, "error");
            throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
        }
    }

    public static final <T> Object appAwaitFirst(Observable<T> observable, Context context, Continuation<? super T> continuation) {
        Observable<T> observableM11119z = observable.m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "first()");
        return appAwaitSingle$default(observableM11119z, context, null, continuation, 2, null);
    }

    public static /* synthetic */ Object appAwaitFirst$default(Observable observable, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return appAwaitFirst(observable, context, continuation);
    }

    public static final <T> Object appAwaitSingle(Observable<T> observable, Context context, Boolean bool, Continuation<? super T> continuation) {
        return C3404f.m4225M(new C67402(observable, context, bool, null), continuation);
    }

    public static /* synthetic */ Object appAwaitSingle$default(Observable observable, Context context, Boolean bool, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        if ((i & 2) != 0) {
            bool = Boolean.FALSE;
        }
        return appAwaitSingle(observable, context, bool, continuation);
    }
}
