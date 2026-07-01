package b.i.a.f.h.c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import b.i.a.f.c.a.a;
import b.i.a.f.e.h.c;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends b.i.a.f.e.k.d<t> {
    public final a.C0033a A;

    public o(Context context, Looper looper, b.i.a.f.e.k.c cVar, a.C0033a c0033a, c.a aVar, c.b bVar) {
        super(context, looper, 68, cVar, aVar, bVar);
        a.C0033a.C0034a c0034a = new a.C0033a.C0034a(c0033a == null ? a.C0033a.j : c0033a);
        byte[] bArr = new byte[16];
        a.a.nextBytes(bArr);
        c0034a.c = Base64.encodeToString(bArr, 11);
        this.A = new a.C0033a(c0034a);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public final int l() {
        return 12800000;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof t ? (t) iInterfaceQueryLocalInterface : new s(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final Bundle u() {
        a.C0033a c0033a = this.A;
        Objects.requireNonNull(c0033a);
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", c0033a.k);
        bundle.putBoolean("force_save_dialog", c0033a.l);
        bundle.putString("log_session_id", c0033a.m);
        return bundle;
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
