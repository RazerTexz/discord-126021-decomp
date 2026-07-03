package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.content.Context;
import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3197a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3270e;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3309o;
import p007b.p225i.p226a.p288f.p299e.p304k.C3363k;
import p007b.p225i.p226a.p288f.p299e.p305l.C3395a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p316c.BinderC3453b;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.b.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3214q extends BinderC3453b implements IInterface {

    /* JADX INFO: renamed from: a */
    public final Context f9240a;

    public BinderC3214q(Context context) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.f9240a = context;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p316c.BinderC3453b
    /* JADX INFO: renamed from: c */
    public final boolean mo3994c(int i, Parcel parcel, Parcel parcel2, int i2) {
        BasePendingResult basePendingResultMo4049b;
        BasePendingResult basePendingResultMo4049b2;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            m3995g();
            C3210m.m3990b(this.f9240a).m3991a();
            return true;
        }
        m3995g();
        C3198a c3198aM3973a = C3198a.m3973a(this.f9240a);
        GoogleSignInAccount googleSignInAccountM3975b = c3198aM3973a.m3975b();
        GoogleSignInOptions googleSignInOptionsM3976c = GoogleSignInOptions.f20433n;
        if (googleSignInAccountM3975b != null) {
            googleSignInOptionsM3976c = c3198aM3973a.m3976c();
        }
        Context context = this.f9240a;
        Objects.requireNonNull(googleSignInOptionsM3976c, "null reference");
        C3197a c3197a = new C3197a(context, googleSignInOptionsM3976c);
        if (googleSignInAccountM3975b == null) {
            AbstractC3268c abstractC3268c = c3197a.f9332g;
            Context context2 = c3197a.f9326a;
            boolean z2 = c3197a.m3972f() == 3;
            C3204g.f9235a.m4179a("Signing out", new Object[0]);
            C3204g.m3986a(context2);
            if (z2) {
                Status status = Status.f20489j;
                C1460d.m595z(status, "Result must not be null");
                basePendingResultMo4049b = new C3309o(abstractC3268c);
                basePendingResultMo4049b.mo3989b(status);
            } else {
                basePendingResultMo4049b = abstractC3268c.mo4049b(new C3205h(abstractC3268c));
            }
            C3363k.m4164a(basePendingResultMo4049b);
            return true;
        }
        AbstractC3268c abstractC3268c2 = c3197a.f9332g;
        Context context3 = c3197a.f9326a;
        boolean z3 = c3197a.m3972f() == 3;
        C3204g.f9235a.m4179a("Revoking access", new Object[0]);
        String strM3979g = C3198a.m3973a(context3).m3979g("refreshToken");
        C3204g.m3986a(context3);
        if (z3) {
            C3395a c3395a = RunnableC3202e.f9231j;
            if (strM3979g == null) {
                Status status2 = new Status(4, null);
                C1460d.m595z(status2, "Result must not be null");
                C1460d.m551o(!status2.m9030w0(), "Status code must not be SUCCESS");
                basePendingResultMo4049b2 = new C3270e(null, status2);
                basePendingResultMo4049b2.mo3989b(status2);
            } else {
                RunnableC3202e runnableC3202e = new RunnableC3202e(strM3979g);
                new Thread(runnableC3202e).start();
                basePendingResultMo4049b2 = runnableC3202e.f9233l;
            }
        } else {
            basePendingResultMo4049b2 = abstractC3268c2.mo4049b(new C3206i(abstractC3268c2));
        }
        C3363k.m4164a(basePendingResultMo4049b2);
        return true;
    }

    /* JADX INFO: renamed from: g */
    public final void m3995g() {
        if (C3404f.m4199D0(this.f9240a, Binder.getCallingUid())) {
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
