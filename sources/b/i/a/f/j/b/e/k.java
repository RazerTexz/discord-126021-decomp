package b.i.a.f.j.b.e;

import android.os.RemoteException;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzce;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements a0 {
    public final Message a;

    public k(Message message) {
        this.a = message;
    }

    @Override // b.i.a.f.j.b.e.a0
    public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
        zzaf zzafVar = new zzaf(1, this.a);
        Objects.requireNonNull(fVar);
        ((u0) fVar.w()).P(new zzce(1, zzafVar, new b.i.a.f.h.m.j(kVar), null, null, false, null));
    }
}
