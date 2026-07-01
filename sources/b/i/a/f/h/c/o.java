package b.i.a.f.h.c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import b.i.a.f.c.a.a$a;
import b.i.a.f.c.a.a$a$a;
import b.i.a.f.e.h.c$a;
import b.i.a.f.e.h.c$b;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends b.i.a.f.e.k.d<t> {
    public final a$a A;

    public o(Context context, Looper looper, b.i.a.f.e.k.c cVar, a$a a_a, c$a c_a, c$b c_b) {
        super(context, looper, 68, cVar, c_a, c_b);
        a$a$a a_a_a = new a$a$a(a_a == null ? a$a.j : a_a);
        byte[] bArr = new byte[16];
        a.a.nextBytes(bArr);
        a_a_a.c = Base64.encodeToString(bArr, 11);
        this.A = new a$a(a_a_a);
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
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
        a$a a_a = this.A;
        Objects.requireNonNull(a_a);
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", a_a.k);
        bundle.putBoolean("force_save_dialog", a_a.l);
        bundle.putString("log_session_id", a_a.m);
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
