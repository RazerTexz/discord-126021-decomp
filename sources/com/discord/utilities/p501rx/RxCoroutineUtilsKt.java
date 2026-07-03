package com.discord.utilities.p501rx;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
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
import kotlinx.coroutines.channels.ProducerScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.InterfaceC12177d;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.InterfaceC12581g;
import p637j0.p642l.p647e.C12716f;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.C13108f;
import p659s.p660a.C13119i1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13126l;
import p659s.p660a.C13159w;
import p659s.p660a.C13161w1;
import p659s.p660a.InterfaceC13169z0;
import p659s.p660a.p663c2.C13061h;
import p659s.p660a.p663c2.C13065l;
import p659s.p660a.p664d2.C13080b;
import p659s.p660a.p664d2.InterfaceC13082d;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2 */
    /* JADX INFO: compiled from: RxCoroutineUtils.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", m10085f = "RxCoroutineUtils.kt", m10086l = {47}, m10087m = "invokeSuspend")
    public static final class C68982<T> extends AbstractC12194k implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observable $this_toFlow;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RxCoroutineUtils.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$subscription.unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68982(Observable observable, Continuation continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C68982 c68982 = new C68982(this.$this_toFlow, continuation);
            c68982.L$0 = obj;
            return c68982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C68982) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                Observable observable = this.$this_toFlow;
                InterfaceC12581g<T> interfaceC12581g = new InterfaceC12581g<T>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$subscription$1
                    @Override // p637j0.InterfaceC12581g
                    public void onCompleted() {
                        C3404f.m4213I(producerScope, null, 1, null);
                    }

                    @Override // p637j0.InterfaceC12581g
                    public void onError(Throwable e) {
                        C3404f.m4335r(producerScope, C3404f.m4267a("Error in Observable", e));
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
                    @Override // p637j0.InterfaceC12581g
                    public void onNext(T value) throws Throwable {
                        AbstractC13142q0 abstractC13142q0M11353a;
                        CoroutineContext coroutineContextPlus;
                        ProducerScope producerScope2 = producerScope;
                        if (producerScope2.offer(value)) {
                            return;
                        }
                        C13061h c13061h = new C13061h(producerScope2, value, null);
                        CoroutineContext coroutineContext = C12179f.f25237j;
                        Thread threadCurrentThread = Thread.currentThread();
                        InterfaceC12177d.b bVar = InterfaceC12177d.b.f25236a;
                        InterfaceC12177d interfaceC12177d = (InterfaceC12177d) coroutineContext.get(bVar);
                        if (interfaceC12177d == null) {
                            C13161w1 c13161w1 = C13161w1.f27916b;
                            abstractC13142q0M11353a = C13161w1.m11353a();
                            coroutineContextPlus = coroutineContext.plus(coroutineContext.plus(abstractC13142q0M11353a));
                            CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
                            if (coroutineContextPlus != coroutineDispatcher && coroutineContextPlus.get(bVar) == null) {
                                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher);
                            }
                        } else {
                            if (!(interfaceC12177d instanceof AbstractC13142q0)) {
                                interfaceC12177d = null;
                            }
                            C13161w1 c13161w2 = C13161w1.f27916b;
                            abstractC13142q0M11353a = C13161w1.f27915a.get();
                            coroutineContextPlus = coroutineContext.plus(coroutineContext);
                            CoroutineDispatcher coroutineDispatcher2 = C13124k0.f27866a;
                            if (coroutineContextPlus != coroutineDispatcher2 && coroutineContextPlus.get(bVar) == null) {
                                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher2);
                            }
                        }
                        C13108f c13108f = new C13108f(coroutineContextPlus, threadCurrentThread, abstractC13142q0M11353a);
                        c13108f.m11191j0(CoroutineStart.DEFAULT, c13108f, c13061h);
                        AbstractC13142q0 abstractC13142q0 = c13108f.f27842n;
                        if (abstractC13142q0 != null) {
                            int i2 = AbstractC13142q0.f27883j;
                            abstractC13142q0.m11337L(false);
                        }
                        while (!Thread.interrupted()) {
                            try {
                                AbstractC13142q0 abstractC13142q1 = c13108f.f27842n;
                                long jMo11339O = abstractC13142q1 != null ? abstractC13142q1.mo11339O() : RecyclerView.FOREVER_NS;
                                if (!(c13108f.m11292M() instanceof InterfaceC13169z0)) {
                                    AbstractC13142q0 abstractC13142q2 = c13108f.f27842n;
                                    if (abstractC13142q2 != null) {
                                        int i3 = AbstractC13142q0.f27883j;
                                        abstractC13142q2.m11334H(false);
                                    }
                                    Object objM11314a = C13119i1.m11314a(c13108f.m11292M());
                                    C13159w c13159w = (C13159w) (objM11314a instanceof C13159w ? objM11314a : null);
                                    if (c13159w != null) {
                                        throw c13159w.f27913b;
                                    }
                                    return;
                                }
                                LockSupport.parkNanos(c13108f, jMo11339O);
                            } catch (Throwable th) {
                                AbstractC13142q0 abstractC13142q3 = c13108f.f27842n;
                                if (abstractC13142q3 != null) {
                                    int i4 = AbstractC13142q0.f27883j;
                                    abstractC13142q3.m11334H(false);
                                }
                                throw th;
                            }
                        }
                        InterruptedException interruptedException = new InterruptedException();
                        c13108f.m11306w(interruptedException);
                        throw interruptedException;
                    }
                };
                Objects.requireNonNull(observable);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC12581g instanceof Subscriber ? observable.m11095U((Subscriber) interfaceC12581g) : observable.m11095U(new C12716f(interfaceC12581g)));
                this.label = 1;
                if (C13065l.m11236a(producerScope, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableM11119z = observable.m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "first()");
        return awaitSingle(observableM11119z, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        final C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        c13126l.mo10902f(new RxCoroutineUtilsKt$awaitSingle$2$1(observable.m11092R().m11097W(new Action1<T>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$1
            @Override // p658rx.functions.Action1
            public final void call(T t) {
                CancellableContinuation cancellableContinuation = c13126l;
                C12112k.a aVar = C12112k.f25169j;
                cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(t));
            }
        }, new Action1<Throwable>() { // from class: com.discord.utilities.rx.RxCoroutineUtilsKt$awaitSingle$2$subscription$2
            @Override // p658rx.functions.Action1
            public final void call(Throwable th) {
                c13126l.mo10906k(th);
            }
        })));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super InterfaceC13082d<? extends T>> continuation) {
        return new C13080b(new C68982(observable, null), null, 0, null, 14);
    }
}
