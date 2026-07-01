package b.i.c.m.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import b.i.c.m.d.k.q0;
import b.i.c.m.d.k.r0;
import b.i.c.m.d.k.v0;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public final b.i.c.m.d.n.b a = new b.i.c.m.d.n.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.c.c f1674b;
    public final Context c;
    public PackageManager d;
    public String e;
    public PackageInfo f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public v0 l;
    public q0 m;

    public h(b.i.c.c cVar, Context context, v0 v0Var, q0 q0Var) {
        this.f1674b = cVar;
        this.c = context;
        this.l = v0Var;
        this.m = q0Var;
    }

    public static void a(h hVar, b.i.c.m.d.s.h.b bVar, String str, b.i.c.m.d.s.c cVar, Executor executor, boolean z2) throws Throwable {
        Objects.requireNonNull(hVar);
        if ("new".equals(bVar.a)) {
            if (new b.i.c.m.d.s.i.b(hVar.c(), bVar.f1749b, hVar.a, "17.3.0").d(hVar.b(bVar.e, str), z2)) {
                cVar.d(2, executor);
                return;
            } else {
                if (b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to create app with Crashlytics service.", null);
                    return;
                }
                return;
            }
        }
        if ("configured".equals(bVar.a)) {
            cVar.d(2, executor);
        } else if (bVar.f) {
            b.a.b("Server says an update is required - forcing a full App update.");
            new b.i.c.m.d.s.i.e(hVar.c(), bVar.f1749b, hVar.a, "17.3.0").d(hVar.b(bVar.e, str), z2);
        }
    }

    public final b.i.c.m.d.s.h.a b(String str, String str2) {
        return new b.i.c.m.d.s.h.a(str, str2, this.l.e, this.h, this.g, b.i.c.m.d.k.h.f(b.i.c.m.d.k.h.l(this.c), str2, this.h, this.g), this.j, r0.f(this.i).g(), this.k, "0");
    }

    public String c() {
        Context context = this.c;
        int iN = b.i.c.m.d.k.h.n(context, "com.crashlytics.ApiEndpoint", "string");
        return iN > 0 ? context.getString(iN) : "";
    }
}
