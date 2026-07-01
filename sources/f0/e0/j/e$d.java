package f0.e0.j;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okio.ByteString;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d implements m$b, Function0<Unit> {
    public final m j;
    public final /* synthetic */ e k;

    public e$d(e eVar, m mVar) {
        d0.z.d.m.checkParameterIsNotNull(mVar, "reader");
        this.k = eVar;
        this.j = mVar;
    }

    @Override // f0.e0.j.m$b
    public void a() {
    }

    @Override // f0.e0.j.m$b
    public void b(boolean z2, s sVar) {
        d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
        f0.e0.f.c cVar = this.k.t;
        String strJ = b.d.b.a.a.J(new StringBuilder(), this.k.o, " applyAndAckSettings");
        cVar.c(new e$d$c(strJ, true, strJ, true, this, z2, sVar), 0L);
    }

    @Override // f0.e0.j.m$b
    public void c(boolean z2, int i, int i2, List<b> list) {
        d0.z.d.m.checkParameterIsNotNull(list, "headerBlock");
        if (this.k.c(i)) {
            e eVar = this.k;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
            f0.e0.f.c cVar = eVar.u;
            String str = eVar.o + '[' + i + "] onHeaders";
            cVar.c(new h(str, true, str, true, eVar, i, list, z2), 0L);
            return;
        }
        synchronized (this.k) {
            n nVarB = this.k.b(i);
            if (nVarB != null) {
                nVarB.j(f0.e0.c.w(list), z2);
                return;
            }
            e eVar2 = this.k;
            if (eVar2.r) {
                return;
            }
            if (i <= eVar2.p) {
                return;
            }
            if (i % 2 == eVar2.q % 2) {
                return;
            }
            n nVar = new n(i, this.k, false, z2, f0.e0.c.w(list));
            e eVar3 = this.k;
            eVar3.p = i;
            eVar3.n.put(Integer.valueOf(i), nVar);
            f0.e0.f.c cVarF = this.k.f3638s.f();
            String str2 = this.k.o + '[' + i + "] onStream";
            cVarF.c(new e$d$a(str2, true, str2, true, nVar, this, nVarB, i, list, z2), 0L);
        }
    }

    @Override // f0.e0.j.m$b
    public void d(int i, long j) {
        if (i == 0) {
            synchronized (this.k) {
                e eVar = this.k;
                eVar.I += j;
                eVar.notifyAll();
            }
            return;
        }
        n nVarB = this.k.b(i);
        if (nVarB != null) {
            synchronized (nVarB) {
                nVarB.d += j;
                if (j > 0) {
                    nVarB.notifyAll();
                }
            }
        }
    }

    @Override // f0.e0.j.m$b
    public void e(boolean z2, int i, g0.g gVar, int i2) throws IOException {
        boolean z3;
        boolean z4;
        long j;
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        if (this.k.c(i)) {
            e eVar = this.k;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(gVar, "source");
            g0.e eVar2 = new g0.e();
            long j2 = i2;
            gVar.p0(j2);
            gVar.i0(eVar2, j2);
            f0.e0.f.c cVar = eVar.u;
            String str = eVar.o + '[' + i + "] onData";
            cVar.c(new g(str, true, str, true, eVar, i, eVar2, i2, z2), 0L);
            return;
        }
        n nVarB = this.k.b(i);
        if (nVarB == null) {
            this.k.s(i, a.PROTOCOL_ERROR);
            long j3 = i2;
            this.k.f(j3);
            gVar.skip(j3);
            return;
        }
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        byte[] bArr = f0.e0.c.a;
        n$b n_b = nVarB.g;
        long j4 = i2;
        Objects.requireNonNull(n_b);
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        while (true) {
            boolean z5 = true;
            if (j4 <= 0) {
                break;
            }
            synchronized (n_b.o) {
                z3 = n_b.n;
                z4 = n_b.k.k + j4 > n_b.m;
            }
            if (z4) {
                gVar.skip(j4);
                n_b.o.e(a.FLOW_CONTROL_ERROR);
                break;
            }
            if (z3) {
                gVar.skip(j4);
                break;
            }
            long jI0 = gVar.i0(n_b.j, j4);
            if (jI0 == -1) {
                throw new EOFException();
            }
            j4 -= jI0;
            synchronized (n_b.o) {
                if (n_b.l) {
                    g0.e eVar3 = n_b.j;
                    j = eVar3.k;
                    eVar3.skip(j);
                } else {
                    g0.e eVar4 = n_b.k;
                    if (eVar4.k != 0) {
                        z5 = false;
                    }
                    eVar4.P(n_b.j);
                    if (z5) {
                        n nVar = n_b.o;
                        if (nVar == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        nVar.notifyAll();
                    }
                    j = 0;
                }
            }
            if (j > 0) {
                n_b.a(j);
            }
        }
        if (z2) {
            nVarB.j(f0.e0.c.f3605b, true);
        }
    }

    @Override // f0.e0.j.m$b
    public void f(boolean z2, int i, int i2) {
        if (!z2) {
            f0.e0.f.c cVar = this.k.t;
            String strJ = b.d.b.a.a.J(new StringBuilder(), this.k.o, " ping");
            cVar.c(new e$d$b(strJ, true, strJ, true, this, i, i2), 0L);
            return;
        }
        synchronized (this.k) {
            try {
                if (i == 1) {
                    this.k.f3640y++;
                } else if (i == 2) {
                    this.k.A++;
                } else if (i == 3) {
                    e eVar = this.k;
                    eVar.B++;
                    eVar.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f0.e0.j.m$b
    public void g(int i, int i2, int i3, boolean z2) {
    }

    @Override // f0.e0.j.m$b
    public void h(int i, a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (!this.k.c(i)) {
            n nVarD = this.k.d(i);
            if (nVarD != null) {
                nVarD.k(aVar);
                return;
            }
            return;
        }
        e eVar = this.k;
        Objects.requireNonNull(eVar);
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        f0.e0.f.c cVar = eVar.u;
        String str = eVar.o + '[' + i + "] onReset";
        cVar.c(new j(str, true, str, true, eVar, i, aVar), 0L);
    }

    @Override // f0.e0.j.m$b
    public void i(int i, int i2, List<b> list) {
        d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
        e eVar = this.k;
        Objects.requireNonNull(eVar);
        d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
        synchronized (eVar) {
            if (eVar.M.contains(Integer.valueOf(i2))) {
                eVar.s(i2, a.PROTOCOL_ERROR);
                return;
            }
            eVar.M.add(Integer.valueOf(i2));
            f0.e0.f.c cVar = eVar.u;
            String str = eVar.o + '[' + i2 + "] onRequest";
            cVar.c(new i(str, true, str, true, eVar, i2, list), 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [f0.e0.j.a] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() throws Throwable {
        Throwable th;
        a aVar;
        a aVar2 = a.INTERNAL_ERROR;
        IOException e = null;
        try {
            try {
                this.j.b(this);
                while (this.j.a(false, this)) {
                }
                a aVar3 = a.NO_ERROR;
                try {
                    this.k.a(aVar3, a.CANCEL, null);
                    aVar = aVar3;
                } catch (IOException e2) {
                    e = e2;
                    a aVar4 = a.PROTOCOL_ERROR;
                    e eVar = this.k;
                    eVar.a(aVar4, aVar4, e);
                    aVar = eVar;
                }
            } catch (Throwable th2) {
                th = th2;
                this.k.a(aVar, aVar2, e);
                f0.e0.c.d(this.j);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            aVar = aVar2;
            this.k.a(aVar, aVar2, e);
            f0.e0.c.d(this.j);
            throw th;
        }
        f0.e0.c.d(this.j);
        aVar2 = Unit.a;
        return aVar2;
    }

    @Override // f0.e0.j.m$b
    public void j(int i, a aVar, ByteString byteString) {
        int i2;
        n[] nVarArr;
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        d0.z.d.m.checkParameterIsNotNull(byteString, "debugData");
        byteString.j();
        synchronized (this.k) {
            Object[] array = this.k.n.values().toArray(new n[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            nVarArr = (n[]) array;
            this.k.r = true;
        }
        for (n nVar : nVarArr) {
            if (nVar.m > i && nVar.h()) {
                nVar.k(a.REFUSED_STREAM);
                this.k.d(nVar.m);
            }
        }
    }
}
