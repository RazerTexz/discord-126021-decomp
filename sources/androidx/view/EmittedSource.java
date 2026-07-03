package androidx.view;

import androidx.annotation.MainThread;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
import p659s.p660a.InterfaceC13130m0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements InterfaceC13130m0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.EmittedSource$dispose$1", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C04311 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C04311(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return EmittedSource.this.new C04311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04311) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            EmittedSource.this.removeSource();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$disposeNow$2 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.EmittedSource$disposeNow$2", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C04322 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C04322(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return EmittedSource.this.new C04322(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04322) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            EmittedSource.this.removeSource();
            return Unit.f27425a;
        }
    }

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        C12238m.checkNotNullParameter(liveData, "source");
        C12238m.checkNotNullParameter(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    @MainThread
    private final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // p659s.p660a.InterfaceC13130m0
    public void dispose() {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C3404f.m4211H0(C3404f.m4275c(C13031n.f27700b.mo11194H()), null, null, new C04311(null), 3, null);
    }

    public final Object disposeNow(Continuation<? super Unit> continuation) throws Throwable {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        Object objM4197C1 = C3404f.m4197C1(C13031n.f27700b.mo11194H(), new C04322(null), continuation);
        return objM4197C1 == C12183c.getCOROUTINE_SUSPENDED() ? objM4197C1 : Unit.f27425a;
    }
}
