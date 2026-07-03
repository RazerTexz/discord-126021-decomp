package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.x */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4380x<TResult, TContinuationResult> implements InterfaceC4361e<TContinuationResult>, InterfaceC4359d, InterfaceC4355b, InterfaceC4381y {

    /* JADX INFO: renamed from: a */
    public final Executor f11521a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC4362f<TResult, TContinuationResult> f11522b;

    /* JADX INFO: renamed from: c */
    public final C4358c0<TContinuationResult> f11523c;

    public C4380x(@NonNull Executor executor, @NonNull InterfaceC4362f<TResult, TContinuationResult> interfaceC4362f, @NonNull C4358c0<TContinuationResult> c4358c0) {
        this.f11521a = executor;
        this.f11522b = interfaceC4362f;
        this.f11523c = c4358c0;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* JADX INFO: renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        this.f11521a.execute(new RunnableC4379w(this, task));
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4355b
    /* JADX INFO: renamed from: b */
    public final void mo6005b() {
        this.f11523c.m6026u();
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
    public final void onFailure(@NonNull Exception exc) {
        this.f11523c.m6025t(exc);
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f11523c.m6024s(tcontinuationresult);
    }
}
