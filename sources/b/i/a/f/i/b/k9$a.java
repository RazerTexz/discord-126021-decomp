package b.i.a.f.i.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class k9$a {
    public b.i.a.f.h.l.e1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Long> f1547b;
    public List<b.i.a.f.h.l.a1> c;
    public long d;

    public k9$a(k9 k9Var, j9 j9Var) {
    }

    public final void a(b.i.a.f.h.l.e1 e1Var) {
        this.a = e1Var;
    }

    public final boolean b(long j, b.i.a.f.h.l.a1 a1Var) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.f1547b == null) {
            this.f1547b = new ArrayList();
        }
        if (this.c.size() > 0 && ((this.c.get(0).H() / 1000) / 60) / 60 != ((a1Var.H() / 1000) / 60) / 60) {
            return false;
        }
        long jG = this.d + ((long) a1Var.g());
        if (jG >= Math.max(0, p.i.a(null).intValue())) {
            return false;
        }
        this.d = jG;
        this.c.add(a1Var);
        this.f1547b.add(Long.valueOf(j));
        return this.c.size() < Math.max(1, p.j.a(null).intValue());
    }
}
