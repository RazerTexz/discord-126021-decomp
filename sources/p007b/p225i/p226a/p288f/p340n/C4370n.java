package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.n */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4370n<TResult, TContinuationResult> implements InterfaceC4361e<TContinuationResult>, InterfaceC4359d, InterfaceC4355b, InterfaceC4381y {

    /* JADX INFO: renamed from: a */
    public final Executor f11497a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC4353a<TResult, Task<TContinuationResult>> f11498b;

    /* JADX INFO: renamed from: c */
    public final C4358c0<TContinuationResult> f11499c;

    public C4370n(@NonNull Executor executor, @NonNull InterfaceC4353a<TResult, Task<TContinuationResult>> interfaceC4353a, @NonNull C4358c0<TContinuationResult> c4358c0) {
        this.f11497a = executor;
        this.f11498b = interfaceC4353a;
        this.f11499c = c4358c0;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* JADX INFO: renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        this.f11497a.execute(new RunnableC4369m(this, task));
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4355b
    /* JADX INFO: renamed from: b */
    public final void mo6005b() {
        this.f11499c.m6026u();
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
    public final void onFailure(@NonNull Exception exc) {
        this.f11499c.m6025t(exc);
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f11499c.m6024s(tcontinuationresult);
    }
}
