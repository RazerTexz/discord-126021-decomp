package s.a.b2;

import b.i.a.f.e.o.f;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.Delay;
import s.a.Job2;
import s.a.MainCoroutineDispatcher;

/* JADX INFO: renamed from: s.a.b2.b, reason: use source file name */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HandlerDispatcher3 extends MainCoroutineDispatcher implements Delay {
    public HandlerDispatcher3() {
    }

    public Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return f.x0(j, runnable, coroutineContext);
    }

    public HandlerDispatcher3(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
