package androidx.view;

import androidx.annotation.MainThread;
import b.i.a.f.e.o.f;
import d0.w.h.c;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.m0;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements m0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        m.checkNotNullParameter(liveData, "source");
        m.checkNotNullParameter(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    public static final /* synthetic */ void access$removeSource(EmittedSource emittedSource) {
        emittedSource.removeSource();
    }

    @MainThread
    private final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // s.a.m0
    public void dispose() {
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(f.c(n.f3830b.H()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    public final Object disposeNow(Continuation<? super Unit> continuation) throws Throwable {
        CoroutineDispatcher coroutineDispatcher = k0.a;
        Object objC1 = f.C1(n.f3830b.H(), new EmittedSource$disposeNow$2(this, null), continuation);
        return objC1 == c.getCOROUTINE_SUSPENDED() ? objC1 : Unit.a;
    }
}
