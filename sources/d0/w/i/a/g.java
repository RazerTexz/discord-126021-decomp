package d0.w.i.a;

import d0.z.d.m;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: DebugProbes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "frame");
    }
}
