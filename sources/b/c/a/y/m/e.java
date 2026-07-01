package b.c.a.y.m;

import androidx.annotation.Nullable;
import b.c.a.y.k.j;
import b.c.a.y.k.k;
import b.c.a.y.k.l;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Layer.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final List<b.c.a.y.l.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.c.a.d f438b;
    public final String c;
    public final long d;
    public final e$a e;
    public final long f;

    @Nullable
    public final String g;
    public final List<b.c.a.y.l.f> h;
    public final l i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;

    @Nullable
    public final j q;

    @Nullable
    public final k r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final b.c.a.y.k.b f439s;
    public final List<b.c.a.c0.a<Float>> t;
    public final int u;
    public final boolean v;

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lb/c/a/y/l/b;>;Lb/c/a/d;Ljava/lang/String;JLb/c/a/y/m/e$a;JLjava/lang/String;Ljava/util/List<Lb/c/a/y/l/f;>;Lb/c/a/y/k/l;IIIFFIILb/c/a/y/k/j;Lb/c/a/y/k/k;Ljava/util/List<Lb/c/a/c0/a<Ljava/lang/Float;>;>;Ljava/lang/Object;Lb/c/a/y/k/b;Z)V */
    public e(List list, b.c.a.d dVar, String str, long j, e$a e_a, long j2, @Nullable String str2, List list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List list3, int i6, @Nullable b.c.a.y.k.b bVar, boolean z2) {
        this.a = list;
        this.f438b = dVar;
        this.c = str;
        this.d = j;
        this.e = e_a;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = i6;
        this.f439s = bVar;
        this.v = z2;
    }

    public String a(String str) {
        StringBuilder sbU = b.d.b.a.a.U(str);
        sbU.append(this.c);
        sbU.append("\n");
        e eVarE = this.f438b.e(this.f);
        if (eVarE != null) {
            sbU.append("\t\tParents: ");
            sbU.append(eVarE.c);
            e eVarE2 = this.f438b.e(eVarE.f);
            while (eVarE2 != null) {
                sbU.append("->");
                sbU.append(eVarE2.c);
                eVarE2 = this.f438b.e(eVarE2.f);
            }
            sbU.append(str);
            sbU.append("\n");
        }
        if (!this.h.isEmpty()) {
            sbU.append(str);
            sbU.append("\tMasks: ");
            sbU.append(this.h.size());
            sbU.append("\n");
        }
        if (this.j != 0 && this.k != 0) {
            sbU.append(str);
            sbU.append("\tBackground: ");
            sbU.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l)));
        }
        if (!this.a.isEmpty()) {
            sbU.append(str);
            sbU.append("\tShapes:\n");
            for (b.c.a.y.l.b bVar : this.a) {
                sbU.append(str);
                sbU.append("\t\t");
                sbU.append(bVar);
                sbU.append("\n");
            }
        }
        return sbU.toString();
    }

    public String toString() {
        return a("");
    }
}
