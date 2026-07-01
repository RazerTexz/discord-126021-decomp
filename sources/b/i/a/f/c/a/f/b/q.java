package b.i.a.f.c.a.f.b;

import android.content.Context;
import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends b.i.a.f.h.c.b implements IInterface {
    public final Context a;

    public q(Context context) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.a = context;
    }

    @Override // b.i.a.f.h.c.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
        BasePendingResult basePendingResultB;
        BasePendingResult basePendingResultB2;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            g();
            m.b(this.a).a();
            return true;
        }
        g();
        a aVarA = a.a(this.a);
        GoogleSignInAccount googleSignInAccountB = aVarA.b();
        GoogleSignInOptions googleSignInOptionsC = GoogleSignInOptions.n;
        if (googleSignInAccountB != null) {
            googleSignInOptionsC = aVarA.c();
        }
        Context context = this.a;
        Objects.requireNonNull(googleSignInOptionsC, "null reference");
        b.i.a.f.c.a.f.a aVar = new b.i.a.f.c.a.f.a(context, googleSignInOptionsC);
        if (googleSignInAccountB == null) {
            b.i.a.f.e.h.c cVar = aVar.g;
            Context context2 = aVar.a;
            boolean z2 = aVar.f() == 3;
            g.a.a("Signing out", new Object[0]);
            g.a(context2);
            if (z2) {
                Status status = Status.j;
                b.c.a.a0.d.z(status, "Result must not be null");
                basePendingResultB = new b.i.a.f.e.h.j.o(cVar);
                basePendingResultB.g(status);
            } else {
                basePendingResultB = cVar.b(new h(cVar));
            }
            b.i.a.f.e.k.k.a(basePendingResultB);
            return true;
        }
        b.i.a.f.e.h.c cVar2 = aVar.g;
        Context context3 = aVar.a;
        boolean z3 = aVar.f() == 3;
        g.a.a("Revoking access", new Object[0]);
        String strG = a.a(context3).g("refreshToken");
        g.a(context3);
        if (z3) {
            b.i.a.f.e.l.a aVar2 = e.j;
            if (strG == null) {
                Status status2 = new Status(4, null);
                b.c.a.a0.d.z(status2, "Result must not be null");
                b.c.a.a0.d.o(!status2.w0(), "Status code must not be SUCCESS");
                basePendingResultB2 = new b.i.a.f.e.h.e(null, status2);
                basePendingResultB2.g(status2);
            } else {
                e eVar = new e(strG);
                new Thread(eVar).start();
                basePendingResultB2 = eVar.l;
            }
        } else {
            basePendingResultB2 = cVar2.b(new i(cVar2));
        }
        b.i.a.f.e.k.k.a(basePendingResultB2);
        return true;
    }

    public final void g() {
        if (b.i.a.f.e.o.f.D0(this.a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }
}
