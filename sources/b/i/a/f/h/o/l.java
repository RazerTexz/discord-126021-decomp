package b.i.a.f.h.o;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import b.i.a.f.e.h.c$a;
import b.i.a.f.e.h.c$b;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b.i.a.f.e.k.d<g> {
    public l(Context context, Looper looper, b.i.a.f.e.k.c cVar, c$a c_a, c$b c_b) {
        super(context, looper, 45, cVar, c_a, c_b);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final int l() {
        return 12200000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new h(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.safetynet.service.START";
    }
}
