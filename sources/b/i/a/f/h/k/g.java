package b.i.a.f.h.k;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends b.i.a.f.e.k.d<b> {
    public g(Context context, Looper looper, b.i.a.f.e.k.c cVar, b.i.a.f.e.h.j.f fVar, b.i.a.f.e.h.j.l lVar) {
        super(context, looper, 19, cVar, fVar, lVar);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public final int l() {
        return 12600000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        return iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new d(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }
}
