package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p361c.p369m.p370d.p380q.C4721b;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.C4726a;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.C4728c;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.C4729d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;

/* JADX INFO: renamed from: b.i.c.m.d.k.h0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4629h0 implements C4721b.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4663x f12312a;

    public C4629h0(C4663x c4663x) {
        this.f12312a = c4663x;
    }

    /* JADX INFO: renamed from: a */
    public C4721b m6431a(@NonNull C4741b c4741b) {
        String str = c4741b.f12751c;
        String str2 = c4741b.f12752d;
        String str3 = c4741b.f12753e;
        C4663x c4663x = this.f12312a;
        Context context = c4663x.f12429i;
        int iM6420n = C4628h.m6420n(context, "com.crashlytics.ApiEndpoint", "string");
        String string = iM6420n > 0 ? context.getString(iM6420n) : "";
        C4726a c4726a = new C4726a(new C4728c(string, str, c4663x.f12434n, "17.3.0"), new C4729d(string, str2, c4663x.f12434n, "17.3.0"));
        String str4 = this.f12312a.f12437q.f12259a;
        int iM763m = C1563b.m763m(c4741b);
        C4663x c4663x2 = this.f12312a;
        return new C4721b(str3, str4, iM763m, c4663x2.f12441u, c4726a, c4663x2.f12442v);
    }
}
