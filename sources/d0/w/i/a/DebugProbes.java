package d0.w.i.a;

import d0.z.d.Intrinsics3;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: d0.w.i.a.g, reason: use source file name */
/* JADX INFO: compiled from: DebugProbes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugProbes {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "frame");
    }
}
