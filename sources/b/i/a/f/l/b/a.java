package b.i.a.f.l.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.c;
import b.i.a.f.e.h.j.g0;
import b.i.a.f.e.h.j.i0;
import b.i.a.f.e.k.b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.internal.zam;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b.i.a.f.e.k.d<e> implements b.i.a.f.l.f {
    public final boolean A;
    public final b.i.a.f.e.k.c B;
    public final Bundle C;

    @Nullable
    public final Integer D;

    public a(Context context, Looper looper, boolean z2, b.i.a.f.e.k.c cVar, Bundle bundle, c.a aVar, c.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        this.A = z2;
        this.B = cVar;
        this.C = bundle;
        this.D = cVar.h;
    }

    @Override // b.i.a.f.l.f
    public final void d(c cVar) {
        AnimatableValueParser.z(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.B.a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount googleSignInAccountB = "<<default account>>".equals(account.name) ? b.i.a.f.c.a.f.b.a.a(this.d).b() : null;
            Integer num = this.D;
            Objects.requireNonNull(num, "null reference");
            ((e) w()).f0(new zak(new zas(account, num.intValue(), googleSignInAccountB)), cVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                g0 g0Var = (g0) cVar;
                g0Var.c.post(new i0(g0Var, new zam()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public int l() {
        return 12451000;
    }

    @Override // b.i.a.f.e.k.b, b.i.a.f.e.h.a.f
    public boolean o() {
        return this.A;
    }

    @Override // b.i.a.f.l.f
    public final void p() {
        g(new b.d());
    }

    @Override // b.i.a.f.e.k.b
    public /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // b.i.a.f.e.k.b
    public Bundle u() {
        if (!this.d.getPackageName().equals(this.B.e)) {
            this.C.putString("com.google.android.gms.signin.internal.realClientPackageName", this.B.e);
        }
        return this.C;
    }

    @Override // b.i.a.f.e.k.b
    public String x() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // b.i.a.f.e.k.b
    public String y() {
        return "com.google.android.gms.signin.service.START";
    }
}
