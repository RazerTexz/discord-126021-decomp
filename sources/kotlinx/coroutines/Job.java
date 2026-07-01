package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import s.a.Job2;
import s.a.Job4;
import s.a.Job6;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* JADX INFO: renamed from: kotlinx.coroutines.Job$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Job.kt */
    public static final class Companion implements CoroutineContext.Key<Job> {
        public static final /* synthetic */ Companion a = new Companion();

        static {
            int i = CoroutineExceptionHandler.g;
        }
    }

    Job4 D(Job6 child);

    boolean a();

    void b(CancellationException cause);

    Sequence<Job> e();

    Job2 n(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    CancellationException q();

    boolean start();

    Job2 u(Function1<? super Throwable, Unit> handler);
}
