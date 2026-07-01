package b.i.a.c.a3;

import android.util.Pair;
import b.i.a.c.o2;
import b.i.a.c.o2$c;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements a0$b {
    public final /* synthetic */ o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f806b;

    public /* synthetic */ a(o oVar, Object obj) {
        this.a = oVar;
        this.f806b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00da  */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.a3.a0$b
    public final void a(a0 a0Var, o2 o2Var) {
        long j;
        v$a v_a;
        a0$a a0_aB;
        v$a v_a2;
        o oVar = this.a;
        Object obj = this.f806b;
        Objects.requireNonNull(oVar);
        v vVar = (v) oVar;
        if (vVar.q) {
            v$a v_a3 = vVar.n;
            vVar.n = new v$a(o2Var, v_a3.m, v_a3.n);
            u uVar = vVar.o;
            if (uVar != null) {
                vVar.v(uVar.p);
            }
        } else {
            if (!o2Var.q()) {
                o2Var.n(0, vVar.l);
                o2$c o2_c = vVar.l;
                long j2 = o2_c.f1045z;
                Object obj2 = o2_c.n;
                u uVar2 = vVar.o;
                if (uVar2 != null) {
                    long j3 = uVar2.k;
                    vVar.n.h(uVar2.j.a, vVar.m);
                    long j4 = vVar.m.n + j3;
                    if (j4 != vVar.n.n(0, vVar.l).f1045z) {
                        j = j4;
                    } else {
                        j = j2;
                    }
                } else {
                    j = j2;
                }
                Pair<Object, Long> pairJ = o2Var.j(vVar.l, vVar.m, 0, j);
                Object obj3 = pairJ.first;
                long jLongValue = ((Long) pairJ.second).longValue();
                if (vVar.r) {
                    v$a v_a4 = vVar.n;
                    v_a = new v$a(o2Var, v_a4.m, v_a4.n);
                } else {
                    v_a = new v$a(o2Var, obj2, obj3);
                }
                vVar.n = v_a;
                u uVar3 = vVar.o;
                if (uVar3 != null) {
                    vVar.v(jLongValue);
                    a0$a a0_a = uVar3.j;
                    Object obj4 = a0_a.a;
                    if (vVar.n.n != null && obj4.equals(v$a.l)) {
                        obj4 = vVar.n.n;
                    }
                    a0_aB = a0_a.b(obj4);
                }
                vVar.r = true;
                vVar.q = true;
                vVar.r(vVar.n);
                if (a0_aB != null) {
                    u uVar4 = vVar.o;
                    Objects.requireNonNull(uVar4);
                    uVar4.d(a0_aB);
                }
            }
            if (vVar.r) {
                v$a v_a5 = vVar.n;
                v_a2 = new v$a(o2Var, v_a5.m, v_a5.n);
            } else {
                v_a2 = new v$a(o2Var, o2$c.j, v$a.l);
            }
            vVar.n = v_a2;
        }
        a0_aB = null;
        vVar.r = true;
        vVar.q = true;
        vVar.r(vVar.n);
        if (a0_aB != null) {
            u uVar5 = vVar.o;
            Objects.requireNonNull(uVar5);
            uVar5.d(a0_aB);
        }
    }
}
