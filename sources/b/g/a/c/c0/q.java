package b.g.a.c.c0;

import b.g.a.a.i$d;
import b.g.a.a.p$b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: BasicBeanDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends b.g.a.c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f693b = new Class[0];
    public final b0 c;
    public final b.g.a.c.z.l<?> d;
    public final b.g.a.c.b e;
    public final c f;
    public Class<?>[] g;
    public boolean h;
    public List<s> i;
    public a0 j;

    public q(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar, c cVar, List<s> list) {
        super(jVar);
        this.c = null;
        this.d = lVar;
        if (lVar == null) {
            this.e = null;
        } else {
            this.e = lVar.e();
        }
        this.f = cVar;
        this.i = list;
    }

    public static q e(b.g.a.c.z.l<?> lVar, b.g.a.c.j jVar, c cVar) {
        return new q(lVar, jVar, cVar, Collections.emptyList());
    }

    @Override // b.g.a.c.c
    public i$d a(i$d i_d) {
        i$d i_dH;
        b.g.a.c.b bVar = this.e;
        if (bVar == null || (i_dH = bVar.h(this.f)) == null) {
            i_dH = null;
        }
        i$d i_dI = this.d.i(this.f.l);
        if (i_dI != null) {
            return i_dH == null ? i_dI : i_dH.k(i_dI);
        }
        return i_dH;
    }

    @Override // b.g.a.c.c
    public i b() {
        b0 b0Var = this.c;
        if (b0Var == null) {
            return null;
        }
        if (!b0Var.i) {
            b0Var.h();
        }
        LinkedList<i> linkedList = b0Var.r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return b0Var.r.get(0);
        }
        b0Var.i("Multiple 'as-value' properties defined (%s vs %s)", b0Var.r.get(0), b0Var.r.get(1));
        throw null;
    }

    @Override // b.g.a.c.c
    public p$b c(p$b p_b) {
        p$b p_bZ;
        b.g.a.c.b bVar = this.e;
        if (bVar == null || (p_bZ = bVar.z(this.f)) == null) {
            return p_b;
        }
        return p_b == null ? p_bZ : p_b.a(p_bZ);
    }

    public List<s> d() {
        if (this.i == null) {
            b0 b0Var = this.c;
            if (!b0Var.i) {
                b0Var.h();
            }
            this.i = new ArrayList(b0Var.j.values());
        }
        return this.i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q(b0 b0Var) {
        b.g.a.c.j jVar = b0Var.d;
        c cVar = b0Var.e;
        super(jVar);
        this.c = b0Var;
        b.g.a.c.z.l<?> lVar = b0Var.a;
        this.d = lVar;
        if (lVar == null) {
            this.e = null;
        } else {
            this.e = lVar.e();
        }
        this.f = cVar;
        a0 a0VarR = b0Var.g.r(b0Var.e);
        this.j = a0VarR != null ? b0Var.g.s(b0Var.e, a0VarR) : a0VarR;
    }
}
