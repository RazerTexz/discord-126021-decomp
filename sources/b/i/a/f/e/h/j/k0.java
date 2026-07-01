package b.i.a.f.e.h.j;

import android.os.RemoteException;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.p;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [A, ResultT] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0<A, ResultT> extends p<A, ResultT> {
    public final /* synthetic */ p.a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(p.a aVar, Feature[] featureArr, boolean z2) {
        super(featureArr, z2, null);
        this.c = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TA;Lcom/google/android/gms/tasks/TaskCompletionSource<TResultT;>;)V */
    @Override // b.i.a.f.e.h.j.p
    public final void c(a.b bVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        Objects.requireNonNull(this.c.a);
        ((b.i.a.f.h.b.e) ((b.i.a.f.h.b.i) bVar).w()).Y(new b.i.a.f.h.b.k(taskCompletionSource));
    }
}
