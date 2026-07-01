package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v$d;
import d0.z.d.m;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h$a a = new h$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h$b f3419b;
    public final v$d c;
    public final d0.a d;
    public final Integer e;
    public final String f;

    public h(h$b h_b, v$d v_d, d0.a aVar, Integer num, String str) {
        m.checkNotNullParameter(h_b, "version");
        m.checkNotNullParameter(v_d, "kind");
        m.checkNotNullParameter(aVar, "level");
        this.f3419b = h_b;
        this.c = v_d;
        this.d = aVar;
        this.e = num;
        this.f = str;
    }

    public final v$d getKind() {
        return this.c;
    }

    public final h$b getVersion() {
        return this.f3419b;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("since ");
        sbU.append(this.f3419b);
        sbU.append(' ');
        sbU.append(this.d);
        Integer num = this.e;
        sbU.append(num != null ? m.stringPlus(" error ", num) : "");
        String str = this.f;
        sbU.append(str != null ? m.stringPlus(": ", str) : "");
        return sbU.toString();
    }
}
