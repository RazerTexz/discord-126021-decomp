package b.i.a.f.h.d;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import b.i.a.f.e.h.c$a;
import b.i.a.f.e.h.c$b;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b.i.a.f.e.k.d<b> {
    public final Bundle A;

    public a(Context context, Looper looper, b.i.a.f.e.k.c cVar, b.i.a.f.c.a.c cVar2, c$a c_a, c$b c_b) {
        super(context, looper, 16, cVar, c_a, c_b);
        if (cVar2 != null) {
            throw new NoSuchMethodError();
        }
        this.A = new Bundle();
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a$f
    public final boolean o() {
        b.i.a.f.e.k.c cVar = this.f1382x;
        Account account = cVar.a;
        if (TextUtils.isEmpty(account != null ? account.name : null)) {
            return false;
        }
        if (cVar.d.get(b.i.a.f.c.a.b.c) == null) {
            return !cVar.f1380b.isEmpty();
        }
        throw null;
    }

    @Override // b.i.a.f.e.k.b
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new c(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public final Bundle u() {
        return this.A;
    }

    @Override // b.i.a.f.e.k.b
    public final String x() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // b.i.a.f.e.k.b
    public final String y() {
        return "com.google.android.gms.auth.service.START";
    }
}
