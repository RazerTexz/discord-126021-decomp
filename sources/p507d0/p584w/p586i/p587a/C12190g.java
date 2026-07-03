package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.i.a.g */
/* JADX INFO: compiled from: DebugProbes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12190g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "frame");
    }
}
