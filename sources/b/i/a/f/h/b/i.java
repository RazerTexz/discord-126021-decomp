package b.i.a.f.h.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import b.i.a.f.e.h.j.l;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends b.i.a.f.e.k.d<e> {
    public i(Context context, Looper looper, b.i.a.f.e.k.c cVar, b.i.a.f.e.h.j.f fVar, l lVar) {
        super(context, looper, 126, cVar, fVar, lVar);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new d(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final Feature[] t() {
        return b.d;
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }
}
