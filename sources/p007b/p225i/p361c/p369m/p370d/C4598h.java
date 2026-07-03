package p007b.p225i.p361c.p369m.p370d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4650q0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4660v0;
import p007b.p225i.p361c.p369m.p370d.p373k.EnumC4652r0;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4740a;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.C4748b;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.C4751e;

/* JADX INFO: renamed from: b.i.c.m.d.h */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4598h {

    /* JADX INFO: renamed from: a */
    public final C4706b f12234a = new C4706b();

    /* JADX INFO: renamed from: b */
    public final C4542c f12235b;

    /* JADX INFO: renamed from: c */
    public final Context f12236c;

    /* JADX INFO: renamed from: d */
    public PackageManager f12237d;

    /* JADX INFO: renamed from: e */
    public String f12238e;

    /* JADX INFO: renamed from: f */
    public PackageInfo f12239f;

    /* JADX INFO: renamed from: g */
    public String f12240g;

    /* JADX INFO: renamed from: h */
    public String f12241h;

    /* JADX INFO: renamed from: i */
    public String f12242i;

    /* JADX INFO: renamed from: j */
    public String f12243j;

    /* JADX INFO: renamed from: k */
    public String f12244k;

    /* JADX INFO: renamed from: l */
    public C4660v0 f12245l;

    /* JADX INFO: renamed from: m */
    public C4650q0 f12246m;

    public C4598h(C4542c c4542c, Context context, C4660v0 c4660v0, C4650q0 c4650q0) {
        this.f12235b = c4542c;
        this.f12236c = context;
        this.f12245l = c4660v0;
        this.f12246m = c4650q0;
    }

    /* JADX INFO: renamed from: a */
    public static void m6383a(C4598h c4598h, C4741b c4741b, String str, C4735c c4735c, Executor executor, boolean z2) throws Throwable {
        Objects.requireNonNull(c4598h);
        if ("new".equals(c4741b.f12749a)) {
            if (new C4748b(c4598h.m6385c(), c4741b.f12750b, c4598h.f12234a, "17.3.0").m6691d(c4598h.m6384b(c4741b.f12753e, str), z2)) {
                c4735c.m6686d(2, executor);
                return;
            } else {
                if (C4592b.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to create app with Crashlytics service.", null);
                    return;
                }
                return;
            }
        }
        if ("configured".equals(c4741b.f12749a)) {
            c4735c.m6686d(2, executor);
        } else if (c4741b.f12754f) {
            C4592b.f12227a.m6371b("Server says an update is required - forcing a full App update.");
            new C4751e(c4598h.m6385c(), c4741b.f12750b, c4598h.f12234a, "17.3.0").m6691d(c4598h.m6384b(c4741b.f12753e, str), z2);
        }
    }

    /* JADX INFO: renamed from: b */
    public final C4740a m6384b(String str, String str2) {
        return new C4740a(str, str2, this.f12245l.f12411e, this.f12241h, this.f12240g, C4628h.m6412f(C4628h.m6418l(this.f12236c), str2, this.f12241h, this.f12240g), this.f12243j, EnumC4652r0.m6452f(this.f12242i).m6453g(), this.f12244k, "0");
    }

    /* JADX INFO: renamed from: c */
    public String m6385c() {
        Context context = this.f12236c;
        int iM6420n = C4628h.m6420n(context, "com.crashlytics.ApiEndpoint", "string");
        return iM6420n > 0 ? context.getString(iM6420n) : "";
    }
}
