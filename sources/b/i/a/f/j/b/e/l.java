package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.RemoteException;
import b.i.a.f.e.h.j.k$a;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements a0 {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.f.e.h.j.k f1585b;
    public final d0 c;
    public final SubscribeOptions d;

    public l(i iVar, b.i.a.f.e.h.j.k kVar, d0 d0Var, SubscribeOptions subscribeOptions) {
        this.a = iVar;
        this.f1585b = kVar;
        this.c = d0Var;
        this.d = subscribeOptions;
    }

    @Override // b.i.a.f.j.b.e.a0
    public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
        i iVar = this.a;
        b.i.a.f.e.h.j.k kVar2 = this.f1585b;
        d0 d0Var = this.c;
        SubscribeOptions subscribeOptions = this.d;
        int i = iVar.m;
        if (!fVar.A.a(kVar2.c)) {
            b.i.a.f.h.m.o<k$a, IBinder> oVar = fVar.A;
            oVar.a.put(kVar2.c, new WeakReference<>(new b.i.a.f.h.m.h(kVar2)));
        }
        ((u0) fVar.w()).C(new SubscribeRequest(3, fVar.A.b(kVar2.c), subscribeOptions.a, new b.i.a.f.h.m.j(kVar), subscribeOptions.f3019b, null, 0, null, null, null, false, d0Var, false, null, subscribeOptions.d, 0, i));
    }
}
