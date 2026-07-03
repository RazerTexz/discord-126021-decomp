package p659s.p660a;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import p507d0.p578f0.C12075n;
import p507d0.p584w.AbstractC12174a;

/* JADX INFO: renamed from: s.a.n1 */
/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13134n1 extends AbstractC12174a implements Job {

    /* JADX INFO: renamed from: j */
    public static final C13134n1 f27877j = new C13134n1();

    public C13134n1() {
        super(Job.INSTANCE);
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: D */
    public InterfaceC13138p mo10909D(InterfaceC13144r interfaceC13144r) {
        return C13137o1.f27880j;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: a */
    public boolean mo10910a() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: b */
    public void mo10911b(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: e */
    public Sequence<Job> mo10912e() {
        return C12075n.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: n */
    public InterfaceC13130m0 mo10913n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        return C13137o1.f27880j;
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: q */
    public CancellationException mo10914q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    /* JADX INFO: renamed from: u */
    public InterfaceC13130m0 mo10915u(Function1<? super Throwable, Unit> function1) {
        return C13137o1.f27880j;
    }
}
