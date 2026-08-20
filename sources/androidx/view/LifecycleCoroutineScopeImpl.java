package androidx.view;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1 */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", m10085f = "Lifecycle.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C04411 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C04411(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C04411 c04411 = LifecycleCoroutineScopeImpl.this.new C04411(continuation);
            c04411.L$0 = obj;
            return c04411;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04411) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                C3404f.m4339s(coroutineScope.getCoroutineContext(), null, 1, null);
            }
            return Unit.f27425a;
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(lifecycle, "lifecycle");
        C12238m.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            C3404f.m4339s(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.view.LifecycleCoroutineScope, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.view.LifecycleCoroutineScope
    /* JADX INFO: renamed from: getLifecycle$lifecycle_runtime_ktx_release, reason: from getter */
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        C12238m.checkNotNullParameter(source, "source");
        C12238m.checkNotNullParameter(event, "event");
        if (getLifecycle().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            C3404f.m4339s(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C3404f.m4211H0(this, C13031n.f27700b.mo11194H(), null, new C04411(null), 2, null);
    }
}
