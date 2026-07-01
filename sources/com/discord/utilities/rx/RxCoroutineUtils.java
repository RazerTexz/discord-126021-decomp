package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import d0.Result2;
import d0.Result3;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.Observer2;
import j0.l.e.ObserverSubscriber;
import java.util.Objects;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Produce;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import s.a.Builders4;
import s.a.CancellableContinuationImpl5;
import s.a.CompletionState2;
import s.a.Dispatchers;
import s.a.c2.Channels;
import s.a.c2.Produce2;
import s.a.d2.Builders;
import s.a.d2.Flow3;
import s.a.i1;
import s.a.q0;
import s.a.w1;
import s.a.z0;

/* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtils {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2, reason: invalid class name */
    /* JADX INFO: compiled from: RxCoroutineUtils.kt */
    @DebugMetadata(c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", f = "RxCoroutineUtils.kt", l = {47}, m = "invokeSuspend")
    public static final class AnonymousClass2<T> extends ContinuationImpl6 implements Function2<Produce<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observable $this_toFlow;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RxCoroutineUtils.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$subscription.unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observable observable, Continuation continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_toFlow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                final Produce produce = (Produce) this.L$0;
                Observable observable = this.$this_toFlow;
                Observer2<T> observer2 = new Observer2<T>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$subscription$1
                    @Override // j0.Observer2
                    public void onCompleted() {
                        f.I(produce, null, 1, null);
                    }

                    @Override // j0.Observer2
                    public void onError(Throwable e) {
                        f.r(produce, f.a("Error in Observable", e));
                    }

                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // j0.Observer2
                    public void onNext(T value) throws Throwable {
                        q0 q0VarA;
                        CoroutineContext coroutineContextPlus;
                        Produce produce2 = produce;
                        if (produce2.offer(value)) {
                            return;
                        }
                        Channels channels = new Channels(produce2, value, null);
                        CoroutineContext coroutineContext = CoroutineContextImpl4.j;
                        Thread threadCurrentThread = Thread.currentThread();
                        ContinuationInterceptor.b bVar = ContinuationInterceptor.b.a;
                        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(bVar);
                        if (continuationInterceptor == null) {
                            w1 w1Var = w1.f3847b;
                            q0VarA = w1.a();
                            coroutineContextPlus = coroutineContext.plus(coroutineContext.plus(q0VarA));
                            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                            if (coroutineContextPlus != coroutineDispatcher && coroutineContextPlus.get(bVar) == null) {
                                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher);
                            }
                        } else {
                            if (!(continuationInterceptor instanceof q0)) {
                                continuationInterceptor = null;
                            }
                            w1 w1Var2 = w1.f3847b;
                            q0VarA = w1.a.get();
                            coroutineContextPlus = coroutineContext.plus(coroutineContext);
                            CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
                            if (coroutineContextPlus != coroutineDispatcher2 && coroutineContextPlus.get(bVar) == null) {
                                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher2);
                            }
                        }
                        Builders4 builders4 = new Builders4(coroutineContextPlus, threadCurrentThread, q0VarA);
                        builders4.j0(CoroutineStart.DEFAULT, builders4, channels);
                        q0 q0Var = builders4.n;
                        if (q0Var != null) {
                            int i2 = q0.j;
                            q0Var.L(false);
                        }
                        while (!Thread.interrupted()) {
                            try {
                                q0 q0Var2 = builders4.n;
                                long jO = q0Var2 != null ? q0Var2.O() : RecyclerView.FOREVER_NS;
                                if (!(builders4.M() instanceof z0)) {
                                    q0 q0Var3 = builders4.n;
                                    if (q0Var3 != null) {
                                        int i3 = q0.j;
                                        q0Var3.H(false);
                                    }
                                    Object objA = i1.a(builders4.M());
                                    CompletionState2 completionState2 = (CompletionState2) (objA instanceof CompletionState2 ? objA : null);
                                    if (completionState2 != null) {
                                        throw completionState2.f3846b;
                                    }
                                    return;
                                }
                                LockSupport.parkNanos(builders4, jO);
                            } catch (Throwable th) {
                                q0 q0Var4 = builders4.n;
                                if (q0Var4 != null) {
                                    int i4 = q0.j;
                                    q0Var4.H(false);
                                }
                                throw th;
                            }
                        }
                        InterruptedException interruptedException = new InterruptedException();
                        builders4.w(interruptedException);
                        throw interruptedException;
                    }
                };
                Objects.requireNonNull(observable);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(observer2 instanceof Subscriber ? observable.U((Subscriber) observer2) : observable.U(new ObserverSubscriber(observer2)));
                this.label = 1;
                if (Produce2.a(produce, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "first()");
        return awaitSingle(observableZ, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        final CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        cancellableContinuationImpl5.f(new RxCoroutineUtils2(observable.R().W(new Action1<T>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$1
            @Override // rx.functions.Action1
            public final void call(T t) {
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl5;
                Result2.a aVar = Result2.j;
                cancellableContinuation.resumeWith(Result2.m97constructorimpl(t));
            }
        }, new Action1<Throwable>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$2
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
                cancellableContinuationImpl5.k(th);
            }
        })));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super Flow3<? extends T>> continuation) {
        return new Builders(new AnonymousClass2(observable, null), null, 0, null, 14);
    }
}
