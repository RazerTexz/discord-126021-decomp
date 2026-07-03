package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p659s.p660a.InterfaceC13130m0;
import p659s.p660a.InterfaceC13138p;
import p659s.p660a.InterfaceC13144r;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f27463a;

    /* JADX INFO: renamed from: kotlinx.coroutines.Job$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Job.kt */
    public static final class Companion implements CoroutineContext.Key<Job> {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ Companion f27463a = new Companion();

        static {
            int i = CoroutineExceptionHandler.f27455g;
        }
    }

    /* JADX INFO: renamed from: D */
    InterfaceC13138p mo10909D(InterfaceC13144r child);

    /* JADX INFO: renamed from: a */
    boolean mo10910a();

    /* JADX INFO: renamed from: b */
    void mo10911b(CancellationException cause);

    /* JADX INFO: renamed from: e */
    Sequence<Job> mo10912e();

    /* JADX INFO: renamed from: n */
    InterfaceC13130m0 mo10913n(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    /* JADX INFO: renamed from: q */
    CancellationException mo10914q();

    boolean start();

    /* JADX INFO: renamed from: u */
    InterfaceC13130m0 mo10915u(Function1<? super Throwable, Unit> handler);
}
