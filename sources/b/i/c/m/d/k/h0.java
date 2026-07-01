package b.i.c.m.d.k;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.c.m.d.q.b$b;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0 implements b$b {
    public final /* synthetic */ x a;

    public h0(x xVar) {
        this.a = xVar;
    }

    public b.i.c.m.d.q.b a(@NonNull b.i.c.m.d.s.h.b bVar) {
        String str = bVar.c;
        String str2 = bVar.d;
        String str3 = bVar.e;
        x xVar = this.a;
        Context context = xVar.i;
        int iN = h.n(context, "com.crashlytics.ApiEndpoint", "string");
        String string = iN > 0 ? context.getString(iN) : "";
        b.i.c.m.d.q.d.a aVar = new b.i.c.m.d.q.d.a(new b.i.c.m.d.q.d.c(string, str, xVar.n, "17.3.0"), new b.i.c.m.d.q.d.d(string, str2, xVar.n, "17.3.0"));
        String str4 = this.a.q.a;
        int iM = b.c.a.y.b.m(bVar);
        x xVar2 = this.a;
        return new b.i.c.m.d.q.b(str3, str4, iM, xVar2.u, aVar, xVar2.v);
    }
}
