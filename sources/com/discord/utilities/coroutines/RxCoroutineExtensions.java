package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.utilities.coroutines.AppCoroutineScope2;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.RxCoroutineUtils;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2, reason: invalid class name */
    /* JADX INFO: compiled from: RxCoroutineExtensions.kt */
    @DebugMetadata(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2", f = "RxCoroutineExtensions.kt", l = {35, 40}, m = "invokeSuspend")
    public static final class AnonymousClass2<T> extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Boolean $suppressToast;
        public final /* synthetic */ Observable $this_appAwaitSingle;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public int label;

        /* JADX INFO: renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RxCoroutineExtensions.kt */
        @DebugMetadata(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1", f = "RxCoroutineExtensions.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Throwable $e;
            public final /* synthetic */ Ref$ObjectRef $errorTag;
            public final /* synthetic */ Ref$ObjectRef $weakContext;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Throwable th, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
                super(2, continuation);
                this.$e = th;
                this.$errorTag = ref$ObjectRef;
                this.$weakContext = ref$ObjectRef2;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass1(this.$e, this.$errorTag, this.$weakContext, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                Error.handle(this.$e, (String) this.$errorTag.element, null, (Context) ((WeakReference) this.$weakContext.element).get(), AnonymousClass2.this.$suppressToast);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observable observable, Context context, Boolean bool, Continuation continuation) {
            super(2, continuation);
            this.$this_appAwaitSingle = observable;
            this.$context = context;
            this.$suppressToast = bool;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_appAwaitSingle, this.$context, this.$suppressToast, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((AnonymousClass2) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x009b  */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            T t;
            Throwable th;
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            Error errorCreate;
            MainCoroutineDispatcher mainCoroutineDispatcher;
            AnonymousClass1 anonymousClass1;
            Error error;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = (T) new WeakReference(this.$context);
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                AppCoroutineScope2 appCoroutineScope2 = (AppCoroutineScope2) coroutineScope.getCoroutineContext().get(AppCoroutineScope2.Key.INSTANCE);
                if (appCoroutineScope2 == null || (t = (T) appCoroutineScope2.getErrorTag()) == null) {
                    t = (T) coroutineScope.getClass().getSimpleName();
                }
                ref$ObjectRef4.element = t;
                try {
                    Observable observable = this.$this_appAwaitSingle;
                    this.L$0 = ref$ObjectRef3;
                    this.L$1 = ref$ObjectRef4;
                    this.label = 1;
                    obj = RxCoroutineUtils.awaitSingle(observable, this);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                } catch (Throwable th2) {
                    th = th2;
                    ref$ObjectRef = ref$ObjectRef3;
                    ref$ObjectRef2 = ref$ObjectRef4;
                    errorCreate = Error.create(th);
                    CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                    mainCoroutineDispatcher = MainDispatchers.f3830b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate;
                    this.L$1 = null;
                    this.label = 2;
                    if (f.C1(mainCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    error = errorCreate;
                    Intrinsics3.checkNotNullExpressionValue(error, "error");
                    throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
                }
            }
            if (i == 1) {
                Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
                try {
                    Result3.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    ref$ObjectRef2 = ref$ObjectRef5;
                    ref$ObjectRef = ref$ObjectRef6;
                    errorCreate = Error.create(th);
                    CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
                    mainCoroutineDispatcher = MainDispatchers.f3830b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate;
                    this.L$1 = null;
                    this.label = 2;
                    if (f.C1(mainCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    error = errorCreate;
                    Intrinsics3.checkNotNullExpressionValue(error, "error");
                    throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
                }
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            error = (Error) this.L$0;
            Result3.throwOnFailure(obj);
            Intrinsics3.checkNotNullExpressionValue(error, "error");
            throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
        }
    }

    public static final <T> Object appAwaitFirst(Observable<T> observable, Context context, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "first()");
        return appAwaitSingle$default(observableZ, context, null, continuation, 2, null);
    }

    public static /* synthetic */ Object appAwaitFirst$default(Observable observable, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return appAwaitFirst(observable, context, continuation);
    }

    public static final <T> Object appAwaitSingle(Observable<T> observable, Context context, Boolean bool, Continuation<? super T> continuation) {
        return f.M(new AnonymousClass2(observable, context, bool, null), continuation);
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
