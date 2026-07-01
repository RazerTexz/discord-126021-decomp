package b.i.a.f.j.b.e;

import android.os.RemoteException;
import b.i.a.f.e.h.a$b;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends b.i.a.f.e.h.j.p<f, Void> {
    public final /* synthetic */ a0 c;
    public final /* synthetic */ i d;

    public y(i iVar, a0 a0Var) {
        this.d = iVar;
        this.c = a0Var;
    }

    @Override // b.i.a.f.e.h.j.p
    public final /* synthetic */ void c(a$b a_b, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.c.a((f) a_b, i.j(this.d, taskCompletionSource));
    }
}
